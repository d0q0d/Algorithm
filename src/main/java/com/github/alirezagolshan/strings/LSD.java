package com.github.alirezagolshan.strings;

import java.util.Arrays;

public class LSD {
  public static void sort(String[] a, int w) {
    int N = a.length;
    int R = 256;
    String[] aux = new String[N];

    for (int d = w - 1; d >= 0; d--) {
      int[] count = new int[R + 1];

      // compute frequency counts
      for (int i = 0; i < N; i++) count[a[i].charAt(d) + 1]++;

      // transform counts to indices
      for (int r = 0; r < R; r++) count[r + 1] += count[r];

      // distribute
      for (int i = 0; i < N; i++) aux[count[a[i].charAt(d)]++] = a[i];

      // copy back
      for (int i = 0; i < N; i++) a[i] = aux[i];
    }
  }
}
