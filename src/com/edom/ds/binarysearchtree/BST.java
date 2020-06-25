package com.edom.ds.binarysearchtree;

import com.edom.ds.node.BinaryNode;

import java.util.Comparator;

public class BST<T> {
    BinaryNode<T> root;
    Comparator<T> comparator;

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>((a, b) -> a - b);

        bst.add(4);
        bst.add(3);
        bst.add(7);
        bst.add(6);
        bst.add(1);
        bst.add(0);
        bst.add(8);
        //bst.add(2);

        bst.remove(7);

        System.out.println("inOder....");
        bst.inOrder();
        System.out.println();
        System.out.println("preOrder....");
        bst.preOrder();
        System.out.println();
        System.out.println("postOrder....");
        bst.postOrder();
        System.out.println();

        System.out.println("Contains 1: " + bst.contains(1));
        System.out.println("Contains 7: " + bst.contains(7));
        System.out.println("Contains 9: " + bst.contains(9));
    }

    public BST(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void add(T value) {
        root = add(value, root);
    }

    public BinaryNode<T> add(T value, BinaryNode<T> current) {
        if (current == null) {
            return new BinaryNode<>(value);
        }

        if (comparator.compare(value, current.value) <= -1) {
            current.left = add(value, current.left);
        } else {
            current.right = add(value, current.right);
        }

        return current;
    }

    public void remove(T value) {
        remove(value, root);
    }

    public BinaryNode<T> remove(T value, BinaryNode<T> root) {
        if (root == null) return null;

        if (comparator.compare(value, root.value) <= -1) {
            root.left = remove(value, root.left);
        }
        else if (comparator.compare(value, root.value) >= 1) {
            root.right = remove(value, root.right);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null && root.right != null) {
                BinaryNode<T> temp = findMinimum(root.right);
                remove(temp.value, root);

                root.value = temp.value;
            } else {
                root = (root.left == null) ? root.right : root.left;
            }
        }

        return root;
    }

    public BinaryNode<T> findMinimum(BinaryNode<T> current) {
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public boolean contains(T value) {
        return contains(value, root);
    }

    public boolean contains(T value, BinaryNode<T> root) {
        if (root == null) return false;

        if (comparator.compare(value, root.value) == 0) {
            return true;
        }

        if (comparator.compare(value, root.value) <= -1) {
            return contains(value, root.left);
        }
        else if (comparator.compare(value, root.value) >= 1) {
            return contains(value, root.right);
        }
        return false;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(BinaryNode<T> root) {
        if (root == null) return;;

        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(BinaryNode<T> root) {
        if (root == null) return;;

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(BinaryNode<T> root) {
        if (root == null) return;;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }
}
