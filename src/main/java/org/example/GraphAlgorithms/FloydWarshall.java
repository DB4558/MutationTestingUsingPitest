package org.example.GraphAlgorithms;

public class FloydWarshall {
    private static final int INF = Integer.MAX_VALUE;

    public int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize the distance matrix with the graph values
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0;  // Distance from a node to itself is 0
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j];  // Edge weight
                } else {
                    dist[i][j] = INF;  // No edge between nodes
                }
            }
        }

        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // If there is a path through k that improves the current path, update the distance
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

}
