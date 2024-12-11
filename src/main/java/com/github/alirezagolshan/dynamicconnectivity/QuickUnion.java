package com.github.alirezagolshan.dynamicconnectivity;

public class QuickUnion {

  private final int[] array;

  public QuickUnion(int size) {
    array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = i;
    }
  }

  public int root(int i) {
    while (i != array[i]) i = array[i];
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    array[i] = j;
  }
}
