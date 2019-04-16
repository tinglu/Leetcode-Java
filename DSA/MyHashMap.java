import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Entry<K, V> {
    final K key;
    V value;
    Entry<K, V> next = null;

    public Entry(K key, V val) {
        this.key = key;
        this.value = val;
    }
}

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    public int size = 0;

    private static final int initialCapacity = 16;
    private final static long BIG_PRIME = 175365371; // The 9,786,124th prime number

    public MyHashMap() {
        this.buckets = new Entry[initialCapacity];
    }

    public MyHashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V val) {

        System.out.println("\nk: " + key);
        int hash = getHash(key);
        System.out.println("hash: " + hash);
        Entry<K, V> entry = new Entry<>(key, val);
        Entry<K, V> existing = buckets[hash];
        if (existing == null) {
            buckets[hash] = entry;
            this.size++;
        } else {
            while (existing.next != null) {
                if (existing.next.key.equals(key)) {
                    existing.next.value = val;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = val;
            } else {
                existing.next = entry;
                this.size++;
            }
        }
    }

    public V get(K key) {
        Entry<K, V> entry = buckets[getHash(key)];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }


    private int getHash(K k) {
        int result = k.hashCode();
//        System.out.println("\nk: " + k);
//        System.out.println("result: " + result);
//        if (result >= 0) {
//            // 0 always at index 0.
//            int hash = (int) (result * BIG_PRIME) % getSize();
//            System.out.println((result * BIG_PRIME) % getSize());
//            System.out.println("?" + hash);
//            return hash;
//        } else {
//            return (int) ((Integer.MAX_VALUE - result) * BIG_PRIME) % getSize();
//        }
        return result % getSize();
    }

    public int getSize() {
        return this.buckets.length;
    }

    @Test
    public static void testMyHashMap() {
        MyHashMap<String, String> myMap = new MyHashMap<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");

        assertNotNull(myMap);
        assertEquals(4, myMap.size);
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney", myMap.get("Australia"));
    }

    public static void main(String[] args) {
        testMyHashMap();
    }
}
