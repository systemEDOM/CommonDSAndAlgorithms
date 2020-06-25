package com.edom.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BinaryHeap<T> {

    private T[] heap;
    private int size;
    private Comparator comparator;

    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t2.compareTo(t1);
            }
        };

        BinaryHeap<String> minHeap = new BinaryHeap<>(4, comparator);
        /*minHeap.insert(7);
        minHeap.insert(5);
        minHeap.insert(6);*/

        minHeap.insert("C");
        minHeap.insert("B");
        minHeap.insert("D");
        minHeap.insert("A");

        System.out.println("Peek: " + minHeap.peek());
        System.out.println("Deleted: " + minHeap.delete());
        System.out.println("Deleted: " + minHeap.delete());

        /*minHeap.insert(8);
        minHeap.insert(1);*/

        minHeap.printHeap();
    }

    public BinaryHeap(int size, Comparator comparator) {
        this.heap = (T[]) new Object[size];
        this.comparator = comparator;
        this.size = 0;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(T value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("The binary heap is full");
        }

        heap[size++] = value;
        heapifyUp(size - 1);
    }

    public void heapifyUp(int childIndex) {
        while (childIndex != 0 && comparator.compare(heap[childIndex], heap[getParent(childIndex)]) <= -1) {
            swap(childIndex, getParent(childIndex));
            childIndex = getParent(childIndex);
        }
    }

    public T delete() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        T itemDeleted = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);
        return itemDeleted;
    }

    public void heapifyDown(int currIndex) {
        int left = getLeft(currIndex);
        int right = getRight(currIndex);
        int smallest = currIndex;

        if (left < size && comparator.compare(heap[left], heap[currIndex]) <= -1) {
            smallest = left;
        }
        if (right < size && comparator.compare(heap[right], heap[smallest]) <= -1) {
            smallest = right;
        }

        while (comparator.compare(heap[smallest], heap[currIndex]) <= -1) {
            swap(currIndex, smallest);
            currIndex = getParent(smallest);
        }
    }

    public int getLeft(int index) {
        return (2 * index) + 1;
    }

    public int getRight(int index) {
        return (2 * index) + 2;
    }

    public void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap[0];
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }
}
