package com.github.alirezagolshan.graph;

import java.util.*;

class Graph<T> {
  private final Map<T, List<T>> adjacencyList;

  public Graph() {
    adjacencyList = new HashMap<>();
  }

  public void addVertex(T vertex) {
    adjacencyList.putIfAbsent(vertex, new ArrayList<>());
  }

  public void addEdge(T source, T destination) {
    adjacencyList.get(source).add(destination);
    adjacencyList.get(destination).add(source);
  }

  public List<T> getAdjacentVertices(T vertex) {
    return adjacencyList.get(vertex);
  }

  public boolean containsVertex(T vertex) {
    return adjacencyList.containsKey(vertex);
  }

  public int size() {
    return adjacencyList.size();
  }

  @Override
  public String toString() {
    return "Graph{" + "adjacencyList=" + adjacencyList + '}';
  }
}
