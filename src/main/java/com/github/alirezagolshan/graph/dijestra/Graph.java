package com.github.alirezagolshan.graph.dijestra;

import java.util.*;

// Find the shortest path from a single source vertex to all other vertices in a weighted graph
class Graph {
  private int V; // Number of vertices
  private List<List<Node>> adj; // Adjacency list representation of the graph

  // Constructor to initialize the graph with a given number of vertices
  Graph(int v) {
    V = v;
    adj = new ArrayList<>(V);
    for (int i = 0; i < V; i++) {
      adj.add(new LinkedList<>());
    }
  }

  // Method to add an edge to the graph
  void addEdge(int src, int dest, int weight) {
    adj.get(src).add(new Node(dest, weight));
    adj.get(dest).add(new Node(src, weight)); // If the graph is undirected
  }

  // Dijkstra's algorithm to find the shortest path from source to all vertices
  void dijkstra(int src) {
    // Priority queue to pick the vertex with the minimum distance
    PriorityQueue<Node> pq = new PriorityQueue<>();
    // Array to store the minimum distance to each vertex
    int[] dist = new int[V];
    // Initialize all distances as infinite
    Arrays.fill(dist, Integer.MAX_VALUE);
    // Distance to the source is 0
    dist[src] = 0;
    pq.add(new Node(src, 0));

    // While there are vertices left to process
    while (!pq.isEmpty()) {
      // Extract the vertex with the minimum distance
      Node node = pq.poll();
      int u = node.vertex;

      // Iterate through all adjacent vertices
      for (Node neighbor : adj.get(u)) {
        int v = neighbor.vertex;
        int weight = neighbor.weight;

        // Relaxation step
        if (dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
          pq.add(new Node(v, dist[v]));
        }
      }
    }

    // Print the shortest path from source to all vertices
    System.out.println("Vertex\t\tDistance from Source");
    for (int i = 0; i < V; i++) {
      System.out.println(i + "\t\t" + dist[i]);
    }
  }

  // Node class representing a vertex and its weight
  class Node implements Comparable<Node> {
    int vertex;
    int weight;

    Node(int v, int w) {
      vertex = v;
      weight = w;
    }

    // Comparator for priority queue based on the weight
    public int compareTo(Node other) {
      return this.weight - other.weight;
    }
  }
}
