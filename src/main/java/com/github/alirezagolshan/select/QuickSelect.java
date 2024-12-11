package com.github.alirezagolshan.select;

// This function returns the k-th smallest element in arr[l..r]
public class QuickSelect {
  public static int quickSelect(int arr[], int low, int high, int k) {
    if (low <= high) {
      int pivot = partition(arr, low, high);
      if (pivot == k - 1) return arr[pivot];
      if (pivot > k - 1) return quickSelect(arr, low, pivot - 1, k);
      return quickSelect(arr, pivot + 1, high, k);
    }
    return Integer.MAX_VALUE;
  }

  static int partition(int arr[], int low, int high) {
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
