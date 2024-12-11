package com.github.alirezagolshan.search;

public class BinarySearch {
  public int search(int[] arr, int key) {
    int i = 0;
    int j = arr.length - 1;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (arr[mid] == key) {
        return mid;
      } else if (arr[mid] > key) {
        j = mid - 1;
      } else if (arr[mid] < key) {
        i = mid + 1;
      }
    }
    return -1;
  }
}
