package crawler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsynchronousCrawler implements Crawler
{
    private final String baseUrl;
    private final String website;
    private final Pattern hrefPattern;
    private final Pattern blobPattern;
    private final BufferedWriter writer;
    private Map<String, Boolean> cache;

    public AsynchronousCrawler(String baseUrl) throws FileNotFoundException
    {
        this.baseUrl = baseUrl;
        this.website = this.baseUrl.split("http[s]?://")[1];
        cache = new ConcurrentHashMap<>();
        cache.put(this.baseUrl, false);
        OutputStream fileOutputStream = new FileOutputStream("/tmp/crawled.txt");
        OutputStreamWriter crawlerFile = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(crawlerFile);
        hrefPattern = Pattern.compile("href=\"(?<link>\\S+)\"");
        blobPattern = Pattern.compile("\\.[a-zA-Z0-9]+$");
    }

    @Override
    public List<String> getAllLinks()
    {
        return null;
    }

    @Override
    public void beginCrawling()
    {
        crawl(baseUrl, "");
    }

    private void crawl(String baseUrl, String relativeUrl)
    {
        try
        {
            HttpURLConnection connection = (HttpURLConnection) new URL(baseUrl + relativeUrl).openConnection();
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0");
            final InputStream inputStream = connection.getInputStream();
            String line;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
            {
                while ((line = reader.readLine()) != null)
                {
                    final Matcher matcher = hrefPattern.matcher(line);
                    if (matcher.find())
                    {
                        // pattern - href="<linkToFollow>"
                        final String linkToFollow = matcher.group("link");
                        if (isFollowableLink(linkToFollow))
                        {
                            final Boolean ifAbsent = cache.putIfAbsent(linkToFollow, true);
                            if (ifAbsent == null)
                            {
                                writer.append(String.format("[200] %s%s%n", baseUrl, linkToFollow)).flush();
                                new Thread(() -> crawl(baseUrl, linkToFollow)).start();
                            }
                        }
                        else if (isSubdomain(linkToFollow))
                        {
                            final Boolean ifAbsent = cache.putIfAbsent(linkToFollow, true);
                            if (ifAbsent == null)
                            {
                                writer.append(String.format("[200] %s%s%n", baseUrl, linkToFollow)).flush();
                                new Thread(() -> crawl(linkToFollow, "")).start();
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.printf("[404] %s%s%n%s%n", baseUrl, relativeUrl, e);
        }
    }

    private boolean isFollowableLink(String linkToFollow)
    {
        return !cache.containsKey(linkToFollow)
                && !isNotBlankOrSelf(linkToFollow)
                && isRelativeUrl(linkToFollow)
                && !isABlobLink(linkToFollow);
    }

    private boolean isNotBlankOrSelf(String link)
    {
        return link.trim().isEmpty() || link.equals("/") || link.startsWith("#");
    }

    private boolean isABlobLink(String link)
    {
        return !link.endsWith(".html") && blobPattern.matcher(link).find();
    }

    private boolean isRelativeUrl(String link)
    {
        return !link.startsWith("//") && link.startsWith("/");
    }

    private boolean isSubdomain(String link)
    {
        return !cache.containsKey(link) && (link.startsWith("http") || link.startsWith("https")) && link
                .endsWith(website);
    }
}
