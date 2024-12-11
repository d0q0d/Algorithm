package com.github.alirezagolshan.graph;

import java.util.*;

// Find the minimum spanning tree (MST) of a connected, undirected graph.
public class KruskalAlgorithm {
  int V, E;
  Edge[] edges;

  KruskalAlgorithm(int v, int e) {
    V = v;
    E = e;
    edges = new Edge[E];
    for (int i = 0; i < e; ++i) {
      edges[i] = new Edge();
    }
  }

  // A utility function to find the set of an element i (uses path compression)
  int find(Subset[] subsets, int i) {
    if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);
    return subsets[i].parent;
  }

  // A function that does union of two sets of x and y (uses union by rank)
  void union(Subset[] subsets, int x, int y) {
    int rootX = find(subsets, x);
    int rootY = find(subsets, y);

    // Attach smaller rank tree under root of higher rank tree
    if (subsets[rootX].rank < subsets[rootY].rank) {
      subsets[rootX].parent = rootY;
    } else if (subsets[rootX].rank > subsets[rootY].rank) {
      subsets[rootY].parent = rootX;
    } else {
      subsets[rootY].parent = rootX;
      subsets[rootX].rank++;
    }
  }

  // The main function to construct MST using Kruskal's algorithm
  void KruskalMST() {
    // This will store the resulting MST
    Edge[] result = new Edge[V];
    int e = 0; // An index variable, used for result[]
    int i = 0; // An index variable, used for sorted edges
    for (i = 0; i < V; ++i) result[i] = new Edge();

    // Step 1: Sort all the edges in non-decreasing order of their weight.
    Arrays.sort(edges);

    // Allocate memory for creating V subsets
    Subset[] subsets = new Subset[V];
    for (i = 0; i < V; ++i) subsets[i] = new Subset();

    // Create V subsets with single elements
    for (int v = 0; v < V; ++v) {
      subsets[v].parent = v;
      subsets[v].rank = 0;
    }

    i = 0; // Index used to pick the smallest edge

    // Number of edges to be taken is equal to V-1
    while (e < V - 1) {
      // Step 2: Pick the smallest edge. Check if it forms a cycle with the spanning-tree formed so
      // far.
      Edge nextEdge = edges[i++];

      int x = find(subsets, nextEdge.src);
      int y = find(subsets, nextEdge.dest);

      // If including this edge doesn't cause a cycle, include it in the result and increment the
      // index of the result for the next edge.
      if (x != y) {
        result[e++] = nextEdge;
        union(subsets, x, y);
      }
      // Else discard the nextEdge
    }

    // Print the contents of the MST
    System.out.println("Following are the edges in the constructed MST");
    int minimumCost = 0;
    for (i = 0; i < e; ++i) {
      System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
      minimumCost += result[i].weight;
    }
    System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
  }
}

class Edge implements Comparable<Edge> {
  int src, dest, weight;

  // Comparator function used for sorting edges by weight
  public int compareTo(Edge compareEdge) {
    return this.weight - compareEdge.weight;
  }
}

class Subset {
  int parent, rank;
}
