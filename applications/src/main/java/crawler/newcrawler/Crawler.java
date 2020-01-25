package crawler.newcrawler;

import java.io.IOException;
import java.util.List;

/**
 * A crawler when implemented using this I/F must support the following behaviours
 * - crawl(String url) - The entry point to the crawling functionality.
 * - getStatistics() - returns the statistics of the currently ongoing crawl. Must show
 *  # Number of web pages scraped
 *  # Number of web links/page
 *  # Total number of web links
 */
public interface Crawler {
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
