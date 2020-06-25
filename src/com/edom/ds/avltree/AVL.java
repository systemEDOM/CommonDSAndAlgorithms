package com.edom.ds.avltree;

import com.edom.ds.node.BinaryNode;

import java.util.Comparator;

public class AVL<T> {
    BinaryNode<T> root;
    Comparator<T> comparator;

    public static void main(String[] args) {
        AVL<Integer> avl = new AVL<>((a, b) -> a - b);

        avl.add(14);
        avl.add(15);
        avl.add(4);
        avl.add(9);
        avl.add(7);
        avl.add(18);
        avl.add(3);
        avl.add(5);
        avl.add(16);
        avl.add(20);
        avl.add(17);

        avl.remove(18);
        avl.remove(20);
        avl.remove(16);
        avl.remove(17);

        avl.inOrder();
    }

    public AVL(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public int height(BinaryNode<T> curr) {
        if (curr == null) {
            return 0;
        }
        return curr.height;
    }

    public BinaryNode<T> rightRotation(BinaryNode<T> curr) {
        BinaryNode<T> leftSubTree = curr.left;
        BinaryNode<T> rightFromLeftSubTree = leftSubTree.right;


        leftSubTree.right = curr;
        curr.left = rightFromLeftSubTree;

        curr.height = Math.max(height(curr.left), height(curr.right)) + 1;
        leftSubTree.height = Math.max(height(leftSubTree.left), height(leftSubTree.right)) + 1;

        return leftSubTree;
    }

    public BinaryNode<T> leftRotation(BinaryNode<T> curr) {
        BinaryNode<T> rightSubTree = curr.right;
        BinaryNode<T> leftFromRightSubTree = rightSubTree.left;

        rightSubTree.left = curr;
        curr.right = leftFromRightSubTree;

        curr.height = Math.max(height(curr.left), height(curr.right)) + 1;
        rightSubTree.height = Math.max(height(rightSubTree.left), height(rightSubTree.right)) + 1;

        return rightSubTree;
    }

    public int getBalance(BinaryNode<T> curr) {
        if (curr == null) return 0;
        return height(curr.left) - height(curr.right);
    }

    public void add(T value) {
        root = add(value, root);
    }

    public BinaryNode<T> add(T value, BinaryNode<T> curr) {
        if (curr == null) {
            return new BinaryNode<>(value);
        }

        if (comparator.compare(value, curr.value) <= -1) {
            curr.left = add(value, curr.left);
        }
        else if (comparator.compare(value, curr.value) >= 1) {
            curr.right = add(value, curr.right);
        }

        curr.height = Math.max(height(curr.left), height(curr.right)) + 1;

        int currBalance = getBalance(curr);

        if (currBalance > 1 && comparator.compare(value, curr.value) <= -1) {
            return rightRotation(curr);
        }
        if (currBalance > 1 && comparator.compare(value, curr.value) >= 1) {
            curr.left = leftRotation(curr.left);
            return rightRotation(curr);
        }
        if (currBalance < -1 && comparator.compare(value, curr.value) >= 1) {
            return leftRotation(curr);
        }
        if (currBalance < -1 && comparator.compare(value, curr.value) <= -1) {
            curr.right = rightRotation(curr.right);
            return leftRotation(curr);
        }
        return curr;
    }

    public void remove(T value) {
        remove(value, root);
    }

    public BinaryNode<T> remove(T value, BinaryNode<T> curr) {
        if (curr == null) return null;

        if (comparator.compare(value, curr.value) <= -1) {
            curr.left = remove(value, curr.left);
        }
        else if (comparator.compare(value, curr.value) >= 1) {
            curr.right = remove(value, curr.right);
        } else {
            if (curr.left == null && curr.right == null) {
                curr = null;
            } else if (curr.left != null && curr.right != null) {
                BinaryNode<T> temp = findMinimum(curr.right);
                remove(temp.value, curr);

                curr.value = temp.value;
            } else {
                curr = (curr.left == null) ? curr.right : curr.left;
            }
        }

        if (curr == null) return null;

        curr.height = Math.max(height(curr.left), height(curr.right)) + 1;

        int currBalance = getBalance(curr);

        if (currBalance > 1 && comparator.compare(value, curr.value) <= -1) {
            return rightRotation(curr);
        }
        if (currBalance > 1 && comparator.compare(value, curr.value) >= 1) {
            curr.left = leftRotation(curr.left);
            return rightRotation(curr);
        }
        if (currBalance < -1 && comparator.compare(value, curr.value) >= 1) {
            return leftRotation(curr);
        }
        if (currBalance < -1 && comparator.compare(value, curr.value) <= -1) {
            curr.right = rightRotation(curr.right);
            return leftRotation(curr);
        }
        return curr;
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
