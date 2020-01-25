package crawler.newcrawler.parser;

import crawler.newcrawler.storage.InMemoryStorage;
import crawler.newcrawler.storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;

import static crawler.newcrawler.UrlUtility.*;

public class NoobParser implements WebPageParser
{
    private static final Logger logger = Logger.getLogger(NoobParser.class.getName());
    private static final Storage STORAGE = InMemoryStorage.Helper.getInMemoryStorage();

    @Override
    public List<String> parse(WebPage page) throws IOException {
        HttpURLConnection httpClient;
        String location = page.getLocation();
        List<String> parsedUrls = new LinkedList<>();
        httpClient = createHttpClient(location);
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
            while ((line = reader.readLine()) != null) {
                Matcher matcher = getMatcher(line);
                if (matcher.find()) {
                    // pattern - href="<linkToFollow>"
                    String linkToFollow = getMatcherGroup(matcher);
                    linkToFollow = replaceTrailingSlash(linkToFollow);
                    String webSite = page.getWebSite();
                    if (isFollowableLink(linkToFollow)) {
                        logger.info("Parsed url: " + linkToFollow);
                        final Boolean ifAbsent = STORAGE.putIfAbsent(linkToFollow);
                        if (ifAbsent) {
                            parsedUrls.add(String.format("%s%s", page.getLocation(), linkToFollow));
                        }
                    } else if (isSubdomain(linkToFollow, webSite)) {
                        final Boolean ifAbsent = STORAGE.putIfAbsent(linkToFollow);
                        if (ifAbsent) {
                            parsedUrls.add(linkToFollow);
                        }
                    }
                }
            }
        }

        return parsedUrls;
    }

    private HttpURLConnection createHttpClient(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("user-agent", "Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0");
        return connection;
    }
}
