package crawler.newcrawler.processor;

import crawler.newcrawler.parser.NoobParser;
import crawler.newcrawler.parser.WebPage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class PooledThreadProcessor implements PageProcessor {

    private final ExecutorService executorService;
    private static final Logger logger = Logger.getLogger(PooledThreadProcessor.class.getName());
    public PooledThreadProcessor()
    {
        executorService = Executors.newFixedThreadPool(100);
    }

    @Override
    public void process(WebPage url) {
        try {
            new NoobParser().parse(url).forEach(parsed -> executorService.execute(() -> process(new WebPage(parsed))));
        } catch (IOException e) {
            logger.info(String.format("Exception while processing the url: %s %s", url, e));
        }
    }
}
