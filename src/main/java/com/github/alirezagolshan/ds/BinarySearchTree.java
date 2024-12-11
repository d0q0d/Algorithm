package com.github.alirezagolshan.ds;

public class BinarySearchTree {
  Node root;

  public BinarySearchTree() {
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

  // Recursive method to search a value
  private boolean searchRec(Node root, int value) {
    if (root == null) return false;

    if (root.value == value) return true;

    if (root.value > value) return searchRec(root.left, value);

    return searchRec(root.right, value);
  }

  public void delete(int value) {
    root = deleteRec(root, value);
  }

  // Recursive method to delete a node
  private Node deleteRec(Node root, int value) {
    if (root == null) return root;

    if (value < root.value) root.left = deleteRec(root.left, value);
    else if (value > root.value) root.right = deleteRec(root.right, value);
    else {
      // Node with only one child or no child
      if (root.left == null) return root.right;
      else if (root.right == null) return root.left;

      root.value = minValue(root.right);

      root.right = deleteRec(root.right, root.value);
    }

    return root;
  }

  private int minValue(Node root) {
    int minValue = root.value;
    while (root.left != null) {
      minValue = root.left.value;
      root = root.left;
    }
    return minValue;
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
