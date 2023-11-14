package xyz.fokion.practice;

public interface Cache<K,V> {
    void put(K key, V value);

    V get(K key);

    int getCapacity();

    void clear();
}
