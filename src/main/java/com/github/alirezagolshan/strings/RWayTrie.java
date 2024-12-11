package com.github.alirezagolshan.strings;

import java.util.LinkedList;
import java.util.Queue;

public class RWayTrie {
  private static final int R = 256;

  private Node root; // root of the trie

  public void put(String key, Object value) {
    root = put(root, key, value, 0);
  }

  private Node put(Node x, String key, Object value, int d) {
    if (x == null) x = new Node();
    if (d == key.length()) {
      x.value = value;
      return x;
    }
    char c = key.charAt(d);
    x.next[c] = put(x.next[c], key, value, d + 1);
    return x;
  }

  public Object get(String key) {
    Node x = get(root, key, 0);
    if (x == null) return null;
    return x.value;
  }

  private Node get(Node x, String key, int d) {
    if (x == null) return null;
    if (d == key.length()) return x;
    char c = key.charAt(d);
    return get(x.next[c], key, d + 1);
  }

  public boolean contains(String key) {
    return get(key) != null;
  }

  public Iterable<String> keysWithPrefix(String prefix) {
    Queue<String> results = new LinkedList<>();
    Node x = get(root, prefix, 0);
    collect(x, new StringBuilder(prefix), results);
    return results;
  }

  private void collect(Node x, StringBuilder prefix, Queue<String> results) {
    if (x == null) return;
    if (x.value != null) results.add(prefix.toString());
    for (char c = 0; c < R; c++) {
      prefix.append(c);
      collect(x.next[c], prefix, results);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }

  private static class Node {
    private Object value;
    private Node[] next = new Node[R];
  }
}
