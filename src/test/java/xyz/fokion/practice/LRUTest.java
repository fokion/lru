package xyz.fokion.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUTest {



    @Test
    void put() {
        LRU<String,String> lru = new LRU<>(3);
        lru.put("1","one");
        lru.put("2","two");
        lru.put("3","three");
        assertEquals("one",lru.get("1"));
        assertEquals("two",lru.get("2"));
        assertEquals("three",lru.get("3"));
        lru.put("4","four");
        assertNull(lru.get("1"));
        assertEquals("two",lru.get("2"));
        assertEquals("three",lru.get("3"));
        assertEquals("four",lru.get("4"));
    }
    @Test
    void get() {
        LRU<String,String> lru = new LRU<>(3);
        lru.put("1","one");
        //1 is head and tail
        lru.put("2","two");
        //2 is head and 1 tail
        lru.put("3","three");
        //3 is head , 2 is middle and 1 tail
        lru.get("1");
        //1 is head, 3 is middle and 2 tail
        lru.get("1");
        lru.put("4","four");
        //4 is head, 1 is middle and 3 tail
        assertNull(lru.get("2"));
        assertEquals("one",lru.get("1"));
        assertEquals("four",lru.get("4"));
    }
}