package leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;

/*
    time: O(1)
    space: O(n)
 */
class LFUCache {

    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet> list;
    int capacity;
    int min;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.vals = new HashMap<>();
        this.counts = new HashMap<>();
        this.list = new HashMap<>();
        this.list.put(1, new LinkedHashSet<>());
        this.min = -1;
    }

    public int get(int key) {
        // when get, freq count + 1

        if (!vals.containsKey(key)) { // not exists
            return -1;
        }

        int count = counts.get(key);
        list.get(count).remove(key); // for udate count+1 in countsMap, min, list, old count for list and min => update

        if (count == min && list.get(count).size() == 0) { // min++, why? if count dont have any node in list, should add min
            min++;
        }

        // general case
        counts.put(key, count+1);
        if (!list.containsKey(count + 1)) { // count + 1 not exists for list
            list.put(count + 1, new LinkedHashSet<>());
        }
        list.get(count + 1).add(key); // general case, count + 1 exists for list

        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (vals.containsKey(key)) { // constains key
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() >= capacity) { // need evict, remove from list, vals
            int evict = (int)list.get(min).iterator().next();
            list.get(min).remove(evict);
            vals.remove(evict);
        }

        vals.put(key, value); // add first time
        counts.put(key, 1);
        min = 1;
        list.get(1).add(key);
    }
}

