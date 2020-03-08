package cache;

import java.util.Optional;

public interface Cache<K,V> {
    /**
     * Returns the key associated with the key
     * @param key the inserted object
     * @return the value associated with the key
     */
    Optional<V> get(K key);

    /**
     * Returns true/false if the key got inserted or not.
     * @param key the key to insert
     * @param value the value to associate with the key
     */
    void put(K key, V value);

    /**
     * Returns the size of the cache
     * @return int
     */
    int size();
}
