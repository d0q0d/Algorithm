package com.github.alirezagolshan.sort;

public class MergeSort {
  public static void sort(int[] arr) {
    int size = arr.length;
    if (size < 2) return;
    int mid = size / 2;
    int[] l = new int[mid];
    int[] r = new int[size - mid];
    for (int i = 0; i < mid; i++) {
      l[i] = arr[i];
    }
    for (int i = mid; i < size; i++) {
      r[i - mid] = arr[i];
    }
    sort(l);
    sort(r);
    merge(arr, l, r, mid, size - mid);
  }

  private static void merge(int[] arr, int[] l, int[] r, int mid, int end) {
    int i = 0, j = 0, k = 0;
    while (i < mid && j < end) {
      if (l[i] <= r[j]) {
        arr[k++] = l[i++];
      } else {
        arr[k++] = r[j++];
      }
    }
    while (i < mid) {
      arr[k++] = l[i++];
    }
    while (j < end) {
      arr[k++] = r[j++];
    }
  }
}
