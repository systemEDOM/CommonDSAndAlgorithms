package com.edom.ds.trie;

import com.edom.ds.node.TrieNode;

public class Trie {
    TrieNode root;

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("jennifer");
        trie.add("jonnofor");

        trie.delete("jonnofor");
        System.out.println(trie.contains("jennifer"));
        System.out.println(trie.contains("jonnofor"));
    }

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, children -> new TrieNode());
        }
        curr.isEndWord = true;
    }

    public boolean contains(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }

        return curr.isEndWord;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    public boolean delete(TrieNode root, String word, int index) {
        if (index == word.length()) {
            if (!root.isEndWord) return false;

            root.isEndWord = false;
            return root.children.isEmpty();
        }

        if (root.children.containsKey(word.charAt(index))) {
            boolean canDelete = delete(root.children.get(word.charAt(index)), word, index+1) && !root.isEndWord;

            if (canDelete) {
                root.children.remove(word.charAt(index));
                return root.children.isEmpty();
            }
        }

        return false;
    }
}
