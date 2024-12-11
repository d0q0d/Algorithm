package com.github.alirezagolshan.shuffling;

import java.security.SecureRandom;
import java.util.*;

public class ShufflingWithSort {
  public static int[] shuffle(int[] arr) {
    var map = new HashMap<Integer, Integer>();
    for (int num : arr) {
      var secureRandom = new SecureRandom();
      map.put(num, secureRandom.nextInt());
    }
    var sortedMap = new LinkedHashMap<Integer, Integer>();
    var list = new ArrayList<Integer>();
    map.forEach((key, value) -> list.add(value));
    list.sort(Comparator.naturalOrder());
    for (int num : list) {
      map.forEach(
          (key, value) -> {
            if (value.equals(num)) {
              sortedMap.put(key, num);
            }
          });
    }
    return sortedMap.keySet().stream().mapToInt(Integer::intValue).toArray();
  }
}
