package crawler.newcrawler;

import crawler.newcrawler.parser.WebPageParser;
import crawler.newcrawler.processor.PageProcessor;
import crawler.newcrawler.storage.Storage;

public class RunConfiguration {
    private Storage storage;
    private WebPageParser parser;
    private PageProcessor processor;

    public RunConfiguration(Storage storage, WebPageParser parser, PageProcessor processor) {
        this.storage = storage;
        this.parser = parser;
        this.processor = processor;
    }

    public PageProcessor getProcessor() {
        return processor;
    }

    public WebPageParser getParser() {
        return parser;
    }

    public Storage getStorage() {
        return storage;
    }

}
