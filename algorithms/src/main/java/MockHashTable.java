import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * This class is going to be another implementation of a hash table. As such this won't support any new functions but
 * would re-implement what already exists.
 * The functions supported would be
 *  - put(k,v)
 *  - v get(k)
 *  - size
 *  - remove
 */
public class MockHashTable<K,V>
{
    // used to the initial capacity of the hashtable
    private int capacity;
    private int size = 1;
    private TableEntry<?, ?>[] items;

    public MockHashTable(int initalCapacity)
    {
        this.capacity = initalCapacity;
        items = new TableEntry<?,?>[capacity];
    }

    public void put(K key, V value)
    {
        int hashcode = getHashcode(key);
        final int keyIdx = hashcode;
        TableEntry<?, ?> item = items[keyIdx];
        if (item != null) {
            System.out.println("Collision detected");
            System.exit(1);
        }
        else
        {
            items[keyIdx] = new TableEntry<>(key, value, hashcode);
            ++size;
        }
    }

    @SuppressWarnings("unchecked")
    public V get(K key)
    {
        return (V) items[getHashcode(key)].getValue();
    }

    private int getHashcode(K key)
    {
        return (key.hashCode()) * 31 & 0xFFFFFFF % size;
    }

    private static class TableEntry<K, V>
    {
        private K key;
        private V value;
        private int hashcode;

        public TableEntry(K key, V value, int hashcode)
        {
            this.key = key;
            this.value = value;
            this.hashcode = hashcode;
        }

        public K getKey()
        {
            return key;
        }

        public V getValue()
        {
            return value;
        }

        public int getHashcode()
        {
            return hashcode;
        }
    }

    public static void main(String[] args) throws IOException
    {
        MockHashTable<String, String> hashTable = new MockHashTable<>(10);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("/home/erahbaw/designpatterns/src/main/resources/random_strings.txt")));
        String line;
        Random random = new Random();
        while ((line = reader.readLine()) != null)
        {
            int randInt = random.nextInt(500);
            hashTable.put(line, "world" + randInt);
            System.out.println("key = " +  line +" value = "+ randInt);
        }
        System.out.printf("Size = %d%n", hashTable.size);
        reader.close();
    }
}
