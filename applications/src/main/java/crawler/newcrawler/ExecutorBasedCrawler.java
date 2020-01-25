package crawler.newcrawler;

import crawler.newcrawler.parser.WebPage;
import crawler.newcrawler.processor.PooledThreadProcessor;

import java.util.List;

/**
 * This class uses Executor service to construct a pool of 100 threads
 * and delegates the parsing of urls to them.
 * The various components of this crawler includes the following
 *
 * - storage -> an abstraction that can support multiple storage
 * - processor -> used for spawning threads for different web pages.
 * - parser -> a simple line by line parser that matches for href pattern in the
 * complete web page's html code and builds a list from it and spawns threads for
 * each one of them.
 *
 * A processor might also deliver some statistics of the crawling for measuring
 * the performance of the crawler.
 */
public class ExecutorBasedCrawler implements Crawler
{
    private final String baseUrl;

    public ExecutorBasedCrawler(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public List<String> getAllLinks()
    {
        return null;
    }

    @Override
    public void beginCrawling()
    {
        new PooledThreadProcessor().process(new WebPage(this.baseUrl));
    }
}
