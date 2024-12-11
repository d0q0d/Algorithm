package com.github.alirezagolshan.ds;

// Can be used for Priority Queues
public class BinaryHeap {
  private final int[] heap;
  private final int capacity;
  private int size;

  public BinaryHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.heap = new int[capacity];
  }

  public void insert(int value) {
    if (size == capacity) {
      throw new IllegalStateException("Heap is full");
    }

    heap[size] = value;
    siftUp(size);
    size++;
  }

  public int extractMin() {
    if (size == 0) {
      throw new IllegalStateException("Heap is empty");
    }

    int min = heap[0];
    heap[0] = heap[--size];
    siftDown(0);

    return min;
  }

  public int getMin() {
    if (size == 0) {
      throw new IllegalStateException("Heap is empty");
    }

    return heap[0];
  }

  private void siftUp(int index) {
    int parent = (index - 1) / 2;
    while (index > 0 && heap[index] < heap[parent]) {
      swap(index, parent);
      index = parent;
      parent = (index - 1) / 2;
    }
  }

  private void siftDown(int index) {
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    int smallest = index;

    if (left < size && heap[left] < heap[smallest]) {
      smallest = left;
    }

    if (right < size && heap[right] < heap[smallest]) {
      smallest = right;
    }

    if (smallest != index) {
      swap(index, smallest);
      siftDown(smallest);
    }
  }

  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
}
