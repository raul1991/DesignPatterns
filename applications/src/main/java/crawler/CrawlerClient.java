package crawler;

import crawler.newcrawler.ExecutorBasedCrawler;

public class CrawlerClient
{
    public static void main(String[] args)
    {
        new ExecutorBasedCrawler("https://www.w3schools.com/html/default.asp").beginCrawling();
    }
}
