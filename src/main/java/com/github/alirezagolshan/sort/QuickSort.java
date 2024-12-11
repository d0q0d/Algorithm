package com.github.alirezagolshan.sort;

public class QuickSort {
  public static int[] sort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);
      sort(arr, low, pivot - 1);
      sort(arr, pivot + 1, high);
    }
    return arr;
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }
}
