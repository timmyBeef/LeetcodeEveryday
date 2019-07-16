package leetcode;

import java.util.*;

/*
Time complexity : O(1) both for put and get since all operations with ordered dictionary :
get/in/set/move_to_end/popitem (get/containsKey/put/remove) are done in a constant time.

Space complexity : O(capacity) since the space is used only for
an ordered dictionary with at most capacity + 1 elements.
*/

class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

//Hashmap + DoubleLinkedList

