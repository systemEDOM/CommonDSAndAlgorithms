package com.edom.ds.queue;

import com.edom.ds.node.Node;
import com.edom.ds.stack.StackOwn;

public class QueueOwn<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    public static void main(String[] args) {
        QueueOwn<String> s = new QueueOwn<>();
        /*s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        s.enqueue(4);
        s.enqueue(5);*/

        s.enqueue("A");
        s.enqueue("B");
        s.enqueue("C");
        s.enqueue("D");
        s.enqueue("E");
        s.dequeue();
        s.dequeue();
        s.front();
        s.print();
    }

    public void enqueue(T val) {
        Node<T> node = new Node<>(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Node<T> dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node<T> temp = head;
            head = head.next;
            size--;
            return temp;
        }
        return null;
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front value: " + head.val);
        }
    }

    public void print() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.val + " ");
            curr = curr.next;
        }
    }

    public boolean isEmpty () { return size == 0; }
}
