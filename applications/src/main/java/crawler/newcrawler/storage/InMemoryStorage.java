package crawler.newcrawler.storage;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStorage implements Storage {
    private Map<String, Boolean> cache = new ConcurrentHashMap<>();

    @Override
    public void save(String parsedUrl, Boolean isCrawled) {
        cache.putIfAbsent(parsedUrl, isCrawled);
    }

    @Override
    public Boolean putIfAbsent(String linkToFollow) {
        return cache.putIfAbsent(linkToFollow, false) == null;
    }

    public static class Helper
    {
        private static final InMemoryStorage IN_MEMORY_STORAGE = new InMemoryStorage();

        public static InMemoryStorage getInMemoryStorage() {
            return IN_MEMORY_STORAGE;
        }
    }
}
