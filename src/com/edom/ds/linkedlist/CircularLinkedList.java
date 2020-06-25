package com.edom.ds.linkedlist;

import com.edom.ds.node.Node;

public class CircularLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    public static void main(String[] args) {
        CircularLinkedList<String> lk = new CircularLinkedList<>();
        /*lk.insertAtFirst(3);
        lk.insertAtFirst(2);
        lk.insertAtFirst(1);
        lk.insertAtLast(4);
        lk.insertAtLast(5);
        lk.insertAtLast(6);
        lk.insertAtFirst(0);

        lk.deleteFirst();
        lk.deleteFirst();
        lk.delete(2);*/

        lk.insertAtFirst("B");
        lk.insertAtLast("C");
        lk.insertAtLast("D");
        lk.insertAtLast("E");
        lk.insertAtLast("F");
        lk.insertAtLast("G");
        lk.insertAtFirst("A");
        lk.insertAtLast("H");

        lk.deleteFirst();
        lk.deleteFirst();
        lk.delete("C");
        lk.delete("H");
        lk.delete("H");
        lk.print();
    }

    public void insertAtFirst(T val) {
        Node<T> node = new Node<>(val);
        if (isEmpty()) {
            head = tail = node;
            tail.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    public void insertAtLast(T val) {
        Node<T> node = new Node<>(val);
        if (isEmpty()) {
            head = tail = node;
            tail.next = head;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Is empty");
        } else {
            head = head.next;
            tail.next = head;
            size--;
        }
    }

    public void delete(T val) {
        if (isEmpty()) {
            System.out.println("Is empty");
        } else if (head.val == val) {
            deleteFirst();
        } else {
            Node<T> curr = head, prev = null;
            do {
                prev = curr;
                curr = curr.next;
            } while (curr != head && curr.val != val);
            if (curr == head) {
                System.out.println("Value not found");
            } else {
                prev.next = curr.next;
            }
            size--;
        }
    }

    public void print() {
        Node<T> curr = head;
        do {
            System.out.print(curr.val + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    public boolean isEmpty() { return size == 0; }
}
