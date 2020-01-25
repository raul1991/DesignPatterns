package crawler.newcrawler.storage;

import java.io.IOException;
import java.util.List;

public interface Storage {
    void save(String parsedUrl, Boolean isCrawled) throws IOException;

    Boolean putIfAbsent(String linkToFollow);
}
