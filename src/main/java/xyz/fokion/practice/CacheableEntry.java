package xyz.fokion.practice;

public interface CacheableEntry<K, V> extends DoubleLinked<CacheableEntry<K, V>> {
    K getKey();

    V getValue();

}
