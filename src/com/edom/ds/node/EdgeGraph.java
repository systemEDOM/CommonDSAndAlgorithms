package com.edom.ds.node;

public class EdgeGraph<T> {
    public int label;
    public boolean undirected;
    public NodeGraph<T> src;
    public NodeGraph<T> dest;

    public EdgeGraph (NodeGraph<T> src, NodeGraph<T> dest, int label, boolean undirected) {
        this.src = src;
        this.dest = dest;
        this.label = label;
        this.undirected = undirected;
    }

    @Override
    public String toString() {
        return "EdgeGraph{" +
                "label=" + label +
                ", undirected=" + undirected +
                ", src=" + src +
                ", dest=" + dest +
                '}';
    }
}
