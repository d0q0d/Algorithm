package com.github.alirezagolshan.ds;

public class BinaryTree {
  Node root;

  public BinaryTree() {
    root = null;
  }

  public void insert(int value) {
    root = insertRec(root, value);
  }

  private Node insertRec(Node root, int value) {
    if (root == null) {
      root = new Node(value);
      return root;
    }

    if (value < root.value) root.left = insertRec(root.left, value);
    else if (value > root.value) root.right = insertRec(root.right, value);

    return root;
  }

  public boolean search(int value) {
    return searchRec(root, value);
  }

  private boolean searchRec(Node root, int value) {
    if (root == null) return false;

    if (root.value == value) return true;

    if (root.value > value) return searchRec(root.left, value);

    return searchRec(root.right, value);
  }

  public void inOrder() {
    inOrderRec(root);
  }

  private void inOrderRec(Node root) {
    if (root != null) {
      inOrderRec(root.left);
      System.out.print(root.value + " ");
      inOrderRec(root.right);
    }
  }

  public void preOrder() {
    preOrderRec(root);
  }

  private void preOrderRec(Node root) {
    if (root != null) {
      System.out.print(root.value + " ");
      preOrderRec(root.left);
      preOrderRec(root.right);
    }
  }

  public void postOrder() {
    postOrderRec(root);
  }

  private void postOrderRec(Node root) {
    if (root != null) {
      postOrderRec(root.left);
      postOrderRec(root.right);
      System.out.print(root.value + " ");
    }
  }

  static class Node {
    int value;
    Node left, right;

    public Node(int value) {
      this.value = value;
      left = right = null;
    }
  }
}
