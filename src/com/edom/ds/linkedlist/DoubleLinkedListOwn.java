package com.edom.ds.linkedlist;

import com.edom.ds.node.Node;

public class DoubleLinkedListOwn<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    public static void main(String[] args) {
        DoubleLinkedListOwn<String> lk = new DoubleLinkedListOwn<>();
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
        lk.delete("C");
        lk.delete("H");
        lk.delete("H");
        lk.deleteLast();
        lk.print();
        lk.printReverse();
    }

    public void insertAtFirst(T val) {
        Node<T> node = new Node<>(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void insertAtLast(T val) {
        Node<T> node = new Node<>(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Is empty");
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Is empty");
        } else {
            tail.prev.next = tail.next;
            tail = tail.prev;
            size--;
        }
    }

    public void delete(T val) {
        if (isEmpty()) {
            System.out.println("Is empty");
        } else if (head.val == val) {
            deleteFirst();
        } else if (tail.val == val) {
            deleteLast();
        } else {
            Node<T> curr = head;
            while (curr != null && curr.val != val) {
                curr = curr.next;
            }
            if (curr == null) {
                System.out.println("Value not found");
            } else {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            size--;
        }
    }

    public void print() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printReverse() {
        Node<T> curr = tail;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public boolean isEmpty() { return size == 0; }
}
