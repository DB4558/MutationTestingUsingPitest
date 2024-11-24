package org.example.GraphAlgorithms;

import java.util.*;

public class Dijkstra {
    private Map<Integer, List<int[]>> adjList;

    public Dijkstra() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v, int weight) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }

    public Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (Integer node : adjList.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            if (distance > dist.get(node)) {
                continue;
            }

            for (int[] neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = distance + weight;

                if (newDist < dist.get(nextNode)) {
                    dist.put(nextNode, newDist);
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
        return dist;
    }
}
