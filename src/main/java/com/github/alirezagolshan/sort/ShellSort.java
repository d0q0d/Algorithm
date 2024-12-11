package com.github.alirezagolshan.sort;

// Is an optimization of insertion sort that allows the exchange of items that are far apart
public class ShellSort {

  public static int[] sort(int arr[]) {
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < arr.length; i++) {
        int key = arr[i];
        int j = i;
        while (j >= gap && arr[j - gap] > key) {
          arr[j] = arr[j - gap];
          j -= gap;
        }
        arr[j] = key;
      }
    }
    return arr;
  }
}
