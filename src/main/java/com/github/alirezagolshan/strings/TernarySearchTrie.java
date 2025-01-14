package com.github.alirezagolshan.strings;

import java.util.LinkedList;
import java.util.Queue;

public class TernarySearchTrie<Value> {
  private Node root;

  public void put(String key, Value value) {
    root = put(root, key, value, 0);
  }

  private Node put(Node x, String key, Value value, int d) {
    char c = key.charAt(d);
    if (x == null) {
      x = new Node();
      x.c = c;
    }
    if (c < x.c) {
      x.left = put(x.left, key, value, d);
    } else if (c > x.c) {
      x.right = put(x.right, key, value, d);
    } else if (d < key.length() - 1) {
      x.mid = put(x.mid, key, value, d + 1);
    } else {
      x.value = value;
    }
    return x;
  }

  public Value get(String key) {
    Node x = get(root, key, 0);
    if (x == null) return null;
    return x.value;
  }

  private Node get(Node x, String key, int d) {
    if (x == null) return null;
    char c = key.charAt(d);
    if (c < x.c) {
      return get(x.left, key, d);
    } else if (c > x.c) {
      return get(x.right, key, d);
    } else if (d < key.length() - 1) {
      return get(x.mid, key, d + 1);
    } else {
      return x;
    }
  }

  public boolean contains(String key) {
    return get(key) != null;
  }

  public Iterable<String> keysWithPrefix(String prefix) {
    Queue<String> results = new LinkedList<>();
    Node x = get(root, prefix, 0);
    if (x == null) return results;
    if (x.value != null) results.add(prefix);
    collect(x.mid, new StringBuilder(prefix), results);
    return results;
  }

  private void collect(Node x, StringBuilder prefix, Queue<String> results) {
    if (x == null) return;
    collect(x.left, prefix, results);
    if (x.value != null) results.add(prefix.toString() + x.c);
    collect(x.mid, prefix.append(x.c), results);
    prefix.deleteCharAt(prefix.length() - 1);
    collect(x.right, prefix, results);
  }

  private class Node {
    char c; // character
    Node left, mid, right; // left, middle, and right subtries
    Value value; // value associated with string
  }
}
