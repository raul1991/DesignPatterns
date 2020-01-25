package crawler.newcrawler.parser;

import java.io.IOException;
import java.util.List;

/**
 * Supports the following behaviours
 *
 * Returns a list of urls from a web page
 * - List<String> parse() throws IOException
 */
public interface WebPageParser
{
    /**
     * Returns a list of urls after parsing a web page.
     *
     * @return a list of urls
     * @throws IOException in case anything goes wrong during the parsing
     */
    List<String> parse(WebPage page) throws IOException;
}
