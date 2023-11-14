package xyz.fokion.practice;

public class Entry<K,V> implements CacheableEntry<K, V>{
    private final K key;
    private final V value;
    private CacheableEntry<K, V> next;
    private CacheableEntry<K, V> previous;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public CacheableEntry<K, V> getNext() {
        return next;
    }

    @Override
    public CacheableEntry<K, V> getPrevious() {
        return previous;
    }
    @Override
    public void setNext(CacheableEntry<K, V> next) {
        this.next = next;
    }

    @Override
    public void setPrevious(CacheableEntry<K, V> previous) {
        this.previous = previous;
    }

}
