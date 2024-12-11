package com.github.alirezagolshan.bruteforce;

public class ThreeSum {

  public int countTriplesSumEqualToZero(int[] array) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        for (int k = j + 1; k < array.length; k++) {
          if (array[i] + array[j] + array[k] == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
