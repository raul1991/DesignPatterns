package crawler;

import java.io.IOException;

public class CrawlerClient
{
    public static void main(String[] args) throws IOException
    {
        Crawler crawler = new AsynchronousCrawler("http://mit.edu");
        crawler.beginCrawling();
    }
}
