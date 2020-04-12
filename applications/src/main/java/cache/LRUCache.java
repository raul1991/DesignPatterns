package cache;

import java.util.*;

/**
 * This is a basic implementation of a LRUCache in which the item
 * which hasn't be accessed for sometime becomes the least recently used item.
 * During the full load (when capacity of the cache is reached) the cache evicts
 * the least recently used item.
 *
 * To get O(1) access and insert times, we use a map to index into a linked list.
 * The linked list helps to achieve the ordering.
 * | 1 | ->|    | 2 | ->|   | 7 | ->|   | 12 | x|
 *
 * Scenario: Capacity reached
 * Operation: Insert(20)
 * Action: Remove 1, since it hasn't been accessed recently
 * | 2 | ->|   | 7 | ->|   | 12 | ->|    | 20 | x|
 *
 * Scenario: Capacity reached
 * Operation: Insert(21)
 * Action: Remove 2, since it hasn't been accessed recently
 * | 7 | ->|   | 12 | ->|     | 20 | ->|   | 21 | x|
 *
 * Scenario: Capacity reached
 * Operation: Get(7)
 * Action: Get from the map, bring forth the fetched node.
 * | 12 | ->|  | 20 | ->|   | 21 | ->|   | 7 | x|
 *
 * @param <K> the key to insert
 * @param <V> the value associated with it
 */
public class LRUCache<K, V> implements Cache<K,V> {

    private final int capacity;
    private Map<K, Node<V>> cache;
    private Node<V> head;
    private Node<V> tail;
    private int size;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = this.tail = null;
    }

    /**
     * Returns this key and makes this the most recently used
     * item.
     * @param key the inserted object
     * @return the request key or empty Optional
     */
    @Override
    public Optional<V> get(K key) {
        if (cache.containsKey(key)) {
            // remove and move it at the head
            Node<V> existingNode = cache.get(key);
            remove(existingNode);
            cache.put(key, add(existingNode.data));
            return Optional.ofNullable(existingNode.data);
        }
        return Optional.empty();
    }

    @Override
    public void put(K key, V value) {

        if (size == capacity)
        {
            if (exists(key))
            {
                // remove this node, add it as new node at the head
                remove(cache.get(key));
            }
            else
            {
                // remove the eldest node, add new node at the head
                remove(tail);
            }
            Node<V> newNode = add(value);
            cache.put(key, newNode);
        }
        else
        {
            if (exists(key))
            {
                // remove, add to the head
                Node<V> oldNode = cache.get(key);
                remove(oldNode);
                // add new node with the new value
                Node<V> newNode = add(value);
                cache.put(key, newNode);
            }
            else
            {
                // add new node to the end
                Node<V> newNode = add(value);
                cache.put(key, newNode);
            }
            ++size;
        }
    }

    public boolean exists(K key) {
        return Optional.ofNullable(cache.get(key)).isPresent();
    }

    public Optional<V> getLRUItem()
    {
        return tail == null ? Optional.empty() : Optional.ofNullable(tail.data);
    }

    public Optional<V> getMRUItem()
    {
        return head == null ? Optional.empty() : Optional.ofNullable(head.data);
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * Adds to a doubly linked list
     * @param data the node data
     * @return the newly inserted node
     */
    private Node<V> add(V data)
    {
        Node<V> newNode = new Node<>(data);
        if (head == null)
        {
            // first node
            tail = head = newNode;
        }
        else
        {
            head.next = newNode;
            newNode.prev = head;
            newNode.next = null;
            head = newNode;
        }
        return newNode;
    }

    private void remove(Node<V> node) {
        if (head != null)
        {
            if (head == node)
            {
                head = null;
                node.next = null;
                node.prev = null;
                node.data = null;
            }
            else if (node.isEndNode())
            {
                if (node.prev == null)
                {
                    tail = tail.next;
                }
                else {
                    head = head.prev;
                }
            }
            else if (node.isMiddleNode())
            {
                node.prev.next = node.next;
                node.prev = null;
                node.next = null;
            }
        }
    }

    private class Node<R>
    {
        private Node<R> next;
        private Node<R> prev;
        private R data;

        public Node(R data)
        {
            this.next = null;
            this.prev = null;
            this.data = data;
        }

        public boolean isEndNode() {
            return this.prev != null || this.next != null;
        }

        public boolean isMiddleNode() {
            return this.prev != null && this.next != null;
        }
    }

    public boolean isEmpty()
    {
        return head == null && tail == null;
    }

    public void clear()
    {
        if (isEmpty()) return;
        while (tail != null)
        {
            Node<V> temp = tail;
            tail = tail.next;
            temp.data = null;
            temp.next = null;
            temp.prev = null;
            --size;
        }
        cache.clear();
        head = tail = null;
    }
}
