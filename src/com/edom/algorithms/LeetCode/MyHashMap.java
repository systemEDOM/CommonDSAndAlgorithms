package com.edom.algorithms.LeetCode;

import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    class HashEntry {
        int key;
        int val;
        HashEntry next;

        public HashEntry(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private final int TOTAL = 1000;

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,2);
        myHashMap.put(1,2);
        myHashMap.put(3,4);
        System.out.println(myHashMap.get(3));
        myHashMap.remove(3);
        System.out.println(myHashMap.get(3));
    }

    HashEntry[] hashmap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new HashEntry[TOTAL];
        for (int i = 0; i < TOTAL; i++) {
            hashmap[i] = null;
        }
    }

    public int getHashCode(Integer key) {
        return key.hashCode() % TOTAL;
    }

    /** value will always be non-negative. */
    public void put(Integer key, int value) {
        int index = getHashCode(key);
        HashEntry hashEntry = hashmap[index];

        if (hashEntry == null) {
            hashmap[index] = new HashEntry(key, value);
        } else {
            HashEntry curr = hashmap[index];
            while (curr.next != null && curr.key != key) {
                curr = curr.next;
            }

            if (curr.key == key) {
                curr.val = value;
            } else {
                curr.next = new HashEntry(key, value);
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getHashCode(key);

        if (hashmap[index] == null) {
            return -1;
        } else {
            HashEntry curr = hashmap[index];
            while (curr != null && curr.key != key) {
                curr = curr.next;
            }

            if (curr == null) return -1;
            return curr.val;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getHashCode(key);
        if (hashmap[index] != null) {
            HashEntry curr = hashmap[index], prev = null;
            while (curr.next != null && curr.key != key) {
                prev = curr;
                curr = curr.next;
            }

            if (curr.key == key) {
                if (prev == null) {
                    hashmap[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
            }
        }
    }
}