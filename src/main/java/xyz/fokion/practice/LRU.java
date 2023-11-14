package xyz.fokion.practice;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> implements Cache<K, V> {
    private final int capacity;
    private final Map<K, CacheableEntry<K, V>> map = new HashMap<>();
    private CacheableEntry<K, V> head;
    private CacheableEntry<K, V> tail;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void put(K key, V value) {
        CacheableEntry<K, V> entry = new Entry<>(key, value);
        if (map.size() + 1 > capacity) {
            map.remove(tail.getKey());
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        if (head == null) {
            entry.setNext(entry);
            entry.setPrevious(entry);
            head = entry;
            tail = entry;
        } else {
            entry.setNext(head);
            entry.setPrevious(tail);
            head.setPrevious(entry);
            tail.setNext(entry);
            head = entry;
        }
        map.put(key, entry);
    }

    @Override
    public V get(K key) {
        if (map.containsKey(key)) {
            V value = map.get(key).getValue();
            CacheableEntry<K, V> entry = map.get(key);
            if (entry != head) {
                head.setPrevious(null);
                tail.setNext(null);
                CacheableEntry<K, V> next = entry.getNext();
                CacheableEntry<K, V> previous = entry.getPrevious();
                previous.setNext(next);
                if (next != null) {
                    next.setPrevious(previous);
                }else{
                    tail = previous;
                }
                entry.setPrevious(tail);
                head.setPrevious(entry);
                entry.setNext(head);
                head = entry;
            }
            return value;
        }
        return null;
    }


    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void clear() {
        map.clear();
        head = null;
        tail = null;
    }
}
