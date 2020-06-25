package com.edom.ds.graph;

import com.edom.ds.node.EdgeGraph;
import com.edom.ds.node.NodeGraph;
import com.edom.ds.queue.QueueOwn;
import com.edom.ds.stack.StackOwn;

import java.util.*;

public class GraphOwn<T> {
    Map<NodeGraph<T>, List<EdgeGraph<T>>> graph;

    public static void main(String[] args) {
        GraphOwn<Integer> graph = new GraphOwn<>();

        NodeGraph<Integer> node1 = new NodeGraph<>(1);
        NodeGraph<Integer> node2 = new NodeGraph<>(2);
        NodeGraph<Integer> node3 = new NodeGraph<>(3);
        NodeGraph<Integer> node4 = new NodeGraph<>(4);
        NodeGraph<Integer> node5 = new NodeGraph<>(5);
        NodeGraph<Integer> node6 = new NodeGraph<>(6);

        graph.addVertex(node1, node2, 20, true);
        graph.addVertex(node1, node3, 10, true);
        graph.addVertex(node3, node5, 30, true);
        graph.addVertex(node5, node4, 40, true);

        //graph.bfs(node1);
        //graph.removeVertex(node1, node2);
        //graph.removeVertex(node5, node4);
        graph.removeNode(node2);
        graph.dfs(node1);
    }

    public GraphOwn () {
        this.graph = new HashMap<>();
    }

    public void addNode(NodeGraph<T> node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
    }

    public void removeNode(NodeGraph<T> node) {
        if (graph.containsKey(node)) {
            for (EdgeGraph<T> currEdge : graph.get(node)) {
                if (graph.containsKey(currEdge.dest)) {
                    Iterator<EdgeGraph<T>> iterator = graph.get(currEdge.dest).iterator();
                    while (iterator.hasNext()) {
                        EdgeGraph<T> curr = iterator.next();
                        if (curr.dest == node) {
                            iterator.remove();
                        }
                    }
                }
            }

            graph.remove(node);
        }
    }

    public void addVertex(NodeGraph<T> src, NodeGraph<T> dest, int label, boolean undirected) {
        EdgeGraph<T> edgeGraph = new EdgeGraph<>(src, dest, label, undirected);
        if (!graph.containsKey(src)) {
            graph.put(src, new ArrayList<>());
        }
        graph.get(src).add(edgeGraph);
        if (undirected) {
            EdgeGraph<T> edgeGraphUndirected = new EdgeGraph<>(dest, src, label, undirected);
            if (!graph.containsKey(dest)) {
                graph.put(dest, new ArrayList<>());
            }
            graph.get(dest).add(edgeGraphUndirected);
        }
    }

    public void removeVertex(NodeGraph<T> src, NodeGraph<T> dest) {
        if (graph.containsKey(src)) {
            Iterator<EdgeGraph<T>> iterator = graph.get(src).iterator();
            while (iterator.hasNext()) {
                EdgeGraph<T> curr = iterator.next();
                if (curr.dest == dest) {
                    iterator.remove();
                }
            }
        }

        if (graph.containsKey(dest)) {
            Iterator<EdgeGraph<T>> iterator = graph.get(dest).iterator();
            while (iterator.hasNext()) {
                EdgeGraph<T> curr = iterator.next();
                if (curr.dest == src) {
                    iterator.remove();
                }
            }
        }
    }

    public void bfs(NodeGraph<T> root) {
        QueueOwn<NodeGraph<T>> q = new QueueOwn<>();
        Set<NodeGraph<T>> visited = new HashSet<>();
        q.enqueue(root);

        while (!q.isEmpty()) {
            NodeGraph<T> curr = q.dequeue().val;
            if (!visited.contains(curr)) {
                System.out.println(curr);
                visited.add(curr);
                for (EdgeGraph<T> currEdge : graph.get(curr)) {
                    q.enqueue(currEdge.dest);
                }
            }
        }
    }

    public void dfs(NodeGraph<T> root) {
        StackOwn<NodeGraph<T>> s = new StackOwn<>();
        Set<NodeGraph<T>> visited = new HashSet<>();
        s.push(root);

        while (!s.isEmpty()) {
            NodeGraph<T> curr = s.pop().val;
            if (!visited.contains(curr)) {
                System.out.println(curr);
                visited.add(curr);
                for (EdgeGraph<T> currEdge : graph.get(curr)) {
                    s.push(currEdge.dest);
                }
            }
        }
    }
}
