package crawler;

import java.net.URL;
import java.util.List;

public class WebPage {
    private List<URL> links;

    public WebPage(List<URL> links) {
        this.links = links;
    }

    public List<URL> getLinks() {
        return links;
    }
}
