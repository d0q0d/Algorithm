package com.github.alirezagolshan.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {
  public void bfs(Map<Integer, List<Integer>> adjMap, int source) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      int current = queue.remove();
      System.out.println(current);
      queue.addAll(adjMap.get(current));
    }
  }
}
