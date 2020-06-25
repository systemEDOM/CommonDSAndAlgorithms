package com.edom.ds.stack;

import com.edom.ds.node.Node;

public class StackOwn<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    public static void main(String[] args) {
        StackOwn<String> s = new StackOwn<>();
        /*s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);*/

        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        s.push("E");
        s.pop();
        s.pop();
        s.peek();
        s.print();
    }

    public void push(T val) {
        Node<T> node = new Node<>(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public Node<T> pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            Node<T> temp = head;
            head = head.next;
            size--;
            return temp;
        }
        return null;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Peek: " + head.val);
        }
    }

    public void print() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.val + " ");
            curr = curr.next;
        }
    }

    public boolean isEmpty() { return size == 0; }
}
