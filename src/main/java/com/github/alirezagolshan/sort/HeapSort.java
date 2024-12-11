package com.github.alirezagolshan.sort;

public class HeapSort {

  public static void heapSort(int[] arr) {
    int n = arr.length;

    // Build max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
      System.out.println("Heap after heapify at index " + i + ":");
      printHeap(arr, n);
    }

    // Extract elements from heap one by one
    for (int i = n - 1; i > 0; i--) {
      // Move current root to end
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      System.out.println("Heap after moving root to end " + i + ":");
      printHeap(arr, i);

      // Call max heapify on the reduced heap
      heapify(arr, i, 0);
      System.out.println("Heap after heapify at index 0:");
      printHeap(arr, i);
    }
  }

  // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
  private static void heapify(int[] arr, int n, int i) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // left = 2*i + 1
    int right = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (left < n && arr[left] > arr[largest]) largest = left;

    // If right child is larger than largest so far
    if (right < n && arr[right] > arr[largest]) largest = right;

    // If largest is not root
    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      // Recursively heapify the affected sub-tree
      heapify(arr, n, largest);
    }
  }

  // Function to print the array representing the heap
  private static void printHeap(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
