package com.github.alirezagolshan.shuffling;

import java.security.SecureRandom;
import java.util.Arrays;

public class ShufflingWithoutSort {
  public static int[] shuffle(int[] arr) {
    var random = new SecureRandom();
    for (int i = arr.length - 1; i > 0; i--) {
      int randomIndex = random.nextInt(i + 1);
      int temp = arr[randomIndex];
      arr[randomIndex] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }
}
