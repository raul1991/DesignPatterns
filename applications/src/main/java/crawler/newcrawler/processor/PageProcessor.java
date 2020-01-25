package crawler.newcrawler.processor;

import crawler.newcrawler.parser.WebPage;

public interface PageProcessor {
    void process(WebPage url);
}
