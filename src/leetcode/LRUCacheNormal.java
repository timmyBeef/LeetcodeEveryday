package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Time complexity : O(1) both for put and get since all operations with ordered dictionary :
get/in/set/move_to_end/popitem (get/containsKey/put/remove) are done in a constant time.

Space complexity : O(capacity) since the space is used only for
an ordered dictionary with at most capacity + 1 elements.
*/

import java.util.Hashtable;

//Hashmap + DoubleLinkedList

import java.util.Hashtable;

/*

LRU 最新存取過的node, 要放到最前面, 不論什麼動作

put 時, 若超出capacity大小, 移除最不常用（最後一個）的後,加入到最前面

https://leetcode.com/problems/lru-cache/

https://www.youtube.com/watch?v=S6IfqDXWa10&feature=youtu.be

head <->  node....<-> node <-> node <-> node <->  node   <-> tail



use Hashtable + DoubleLinkedList:

        We're asked to implement the structure which provides the following operations
        in O(1) time :

        Get the key / Check if the key exists

        Put the key

        Delete the first added key

        The first two operations in  O(1) time are provided by the standard hashmap,
        and the last one - by double linked list.
*/

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}

public class LRUCacheNormal {

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCacheNormal(int capacity) {
        this.count = 0;
        this.capacity = capacity;


        // null <- head <-> tail -> null

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;//doubly
        tail.pre = head;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node; //doubly
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode preNode = node.pre;
        DLinkedNode postNode = node.post;

        preNode.post = postNode;
        postNode.pre = preNode;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail. tail pre
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node); // 剛用過放到最前面

        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode); // 會加在最前面, 因為剛用過

            ++count;
            // 超過了要 pop 最後一個
            if(count > capacity){
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // 若存在 update the value.
            node.value = value;
            this.moveToHead(node); // 剛用過放到最前面
        }
    }

}


