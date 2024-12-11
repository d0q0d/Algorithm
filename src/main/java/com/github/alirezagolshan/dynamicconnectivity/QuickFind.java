package com.github.alirezagolshan.dynamicconnectivity;

public class QuickFind {

  private final int[] array;

  public QuickFind(int size) {
    array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return array[p] == array[q];
  }

  public void union(int p, int q) {
    int pid = array[p];
    int qid = array[q];
    for (int i = 0; i < array.length; i++) {
      if (array[i] == pid) array[i] = qid;
    }
  }
}
