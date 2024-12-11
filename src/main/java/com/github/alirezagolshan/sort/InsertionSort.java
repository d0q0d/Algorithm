package com.github.alirezagolshan.sort;

// Time complexity O(N^2) but best case is better than selection sort
public class InsertionSort {
  public static int[] sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
    return arr;
  }
}
