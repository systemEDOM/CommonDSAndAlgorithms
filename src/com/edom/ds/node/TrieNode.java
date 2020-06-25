package com.edom.ds.node;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public String content;
    public boolean isEndWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndWord = false;
    }
}
