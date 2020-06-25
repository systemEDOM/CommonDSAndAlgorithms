package com.edom.ds.node;

public class NodeGraph<T> {
    T data;

    public NodeGraph (T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NodeGraph{" +
                "data=" + data +
                '}';
    }
}
