package crawler;

import java.io.IOException;
import java.util.List;

public interface Crawler
{
    /**
     * Gets all the hrefs from the webpages.
     * @return
     */
    List<String> getAllLinks();

    /**
     * Begins crawling the given url.
     */
    void beginCrawling() throws IOException;
}
