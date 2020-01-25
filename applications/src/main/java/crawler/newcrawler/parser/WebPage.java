package crawler.newcrawler.parser;

public class WebPage {
    private final String location;

    public WebPage(String location) {
        this.location = location;
    }

    /**
     * Returns the host from the url.
     * @return a string or null representing the host part of the url.
     */
    public String getLocation() {
        return location;
    }

    public String getWebSite() {
        return this.location.split("http[s]?://")[1];
    }
}
