package com.github.alirezagolshan.graph;

import java.util.*;

public class DFS {

  public void dfs(Map<Integer, List<Integer>> adjMap, int source) {
    var stack = new Stack<Integer>();
    stack.push(source);
    while (!stack.isEmpty()) {
      var current = stack.pop();
      System.out.println(current);
      for (int neighbor : adjMap.get(current)) {
        stack.push(neighbor);
      }
    }
  }

  public void recursiveDFS(Map<Integer, List<Integer>> adjMap, int source) {
    System.out.println(source);
    for (int neighbor : adjMap.get(source)) {
      recursiveDFS(adjMap, neighbor);
    }
  }
}
