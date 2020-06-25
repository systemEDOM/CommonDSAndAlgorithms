package com.edom.ds.node;

public class Node<T> {
    public T val;
    public Node<T> next;
    public Node<T> prev;

    public Node(T val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
