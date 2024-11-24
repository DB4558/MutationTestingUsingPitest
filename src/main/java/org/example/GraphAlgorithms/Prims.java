package org.example.GraphAlgorithms;

import java.util.*;

public class Prims {
    private Map<Integer, List<int[]>> adjList;

    public Prims() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v, int weight) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }

    public List<int[]> primsMST(int start) {
        List<int[]> mst = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        visited.add(start);

        for (int[] edge : adjList.getOrDefault(start, new ArrayList<>())) {
            pq.offer(new int[]{start, edge[0], edge[1]});
        }

        while (!pq.isEmpty() && mst.size() < adjList.size() - 1) {
            int[] edge = pq.poll();
            if (!visited.contains(edge[1])) {
                visited.add(edge[1]);
                mst.add(edge);

                for (int[] neighbor : adjList.getOrDefault(edge[1], new ArrayList<>())) {
                    if (!visited.contains(neighbor[0])) {
                        pq.offer(new int[]{edge[1], neighbor[0], neighbor[1]});
                    }
                }
            }
        }
        return mst;
    }
}
