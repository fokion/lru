package xyz.fokion.practice;

public interface DoubleLinked<V> {
    V getNext();

    V getPrevious();

    void setNext(V next);

    void setPrevious(V previous);
}
