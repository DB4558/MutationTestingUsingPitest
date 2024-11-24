package org.example.GraphAlgorithms;

import java.util.*;

public class Bipartite {

        // Function to check if the graph is Bipartite using BFS
        public static boolean isBipartite(int V,
                                   List<List<Integer>> adj){
            int[] color = new int[V];

            // Initialize all as -1 (uncolored)
            Arrays.fill(color, -1);

            // Iterate through all vertices to handle
            // disconnected graphs
            for (int i = 0; i < V; i++) {

                // If the vertex is uncolored, start BFS from it
                if (color[i] == -1) {

                    // Assign first color (0)
                    color[i] = 0;
                    Queue<Integer> q = new LinkedList<>();

                    // Add starting vertex to the queue
                    q.offer(i);

                    while (!q.isEmpty()) {
                        int u = q.poll();

                        // Traverse all adjacent vertices
                        for (int v : adj.get(u)) {

                            // If the adjacent vertex is
                            // uncolored, assign alternate color
                            if (color[v] == -1) {
                                color[v] = 1 - color[u];

                                q.offer(v);
                            }

                            // If the adjacent vertex has the
                            // same color, graph is not
                            // bipartite
                            else if (color[v] == color[u]) {
                                return false;
                            }
                        }
                    }
                }
            }
            // If no conflicts in coloring, graph is bipartite
            return true;
        }


}
