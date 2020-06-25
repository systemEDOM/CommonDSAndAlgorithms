package com.edom.ds.node;

public class BinaryNode<T> {
    public T value;
    public BinaryNode<T> left;
    public BinaryNode<T> right;
    public int height;

    public BinaryNode(T value) {
        this.value = value;
        left = null;
        right = null;
        height = 0;
    }
}
