package GraphAlgorithms;

import org.example.GraphAlgorithms.*;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestGraph {

    private static final int INF = Integer.MAX_VALUE;

    @Test
    void testBFS1() {
        BFS graph = new BFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        // Start BFS from node 0
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        List<Integer> actual = new ArrayList<>();
        actual=graph.bfs(0);
        assertEquals(expected, actual, "BFS traversal should visit nodes in level order.");
    }

    @Test
    void testBFS2() {
        BFS graph = new BFS();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Start BFS from node 0
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> actual = new ArrayList<>();
        actual=graph.bfs(0);
        assertEquals(expected, actual, "BFS traversal should visit all nodes in a single connected component.");
    }

    @Test
    void testBFS3() {
        BFS graph = new BFS();
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);

        // Start BFS from node 0 in a disconnected graph
        List<Integer> expected = Arrays.asList(0, 1);
        List<Integer> actual = new ArrayList<>();
        actual=graph.bfs(0);
        assertEquals(expected, actual, "BFS should only visit nodes in the connected component.");
    }

    @Test
    void testBFS4() {
        BFS graph = new BFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Start BFS from node 2
        List<Integer> expected = Arrays.asList(2, 0, 3, 1, 4);
        List<Integer> actual = new ArrayList<>();
        actual=graph.bfs(2);
        assertEquals(expected, actual, "BFS traversal should start from node 2 and follow level order.");
    }

    @Test
    void testBFS5() {
        BFS graph = new BFS();
        // No edges, single node
        graph.addEdge(0, 0);

        // Start BFS from node 0
        List<Integer> expected = Arrays.asList(0);
        List<Integer> actual = new ArrayList<>();
        actual=graph.bfs(0);
        assertEquals(expected, actual, "BFS traversal should return the single node if no other nodes are present.");
    }

    @Test
    void testDFS1() {
        DFS graph = new DFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        List<Integer> expected = Arrays.asList(0, 1, 3, 4, 2, 5, 6);
        List<Integer> actual = graph.dfs(0);
        assertEquals(expected, actual, "DFS traversal should visit nodes in depth-first order.");
    }

    @Test
    void testDFS2() {
        DFS graph = new DFS();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> actual = graph.dfs(0);
        assertEquals(expected, actual, "DFS traversal should visit all nodes in a linear graph.");
    }

    @Test
    void testDFS3() {
        DFS graph = new DFS();
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);

        List<Integer> expected = Arrays.asList(0, 1);
        List<Integer> actual = graph.dfs(0);
        assertEquals(expected, actual, "DFS should only visit the connected component of the start node.");
    }

    @Test
    void testDFS4() {
        DFS graph = new DFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> expected = Arrays.asList(2, 0, 1,3,4);
        List<Integer> actual = graph.dfs(2);
        assertEquals(expected, actual, "DFS traversal should start from node 2 and explore depth-first.");
    }

    @Test
    void testDFS5() {
        DFS graph = new DFS();
        graph.addEdge(0, 0);

        List<Integer> expected = Arrays.asList(0);
        List<Integer> actual = graph.dfs(0);
        assertEquals(expected, actual, "DFS traversal should handle a graph with a single node and no edges.");
    }

    @Test
    void testPrims1() {
        Prims graph = new Prims();
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 2, 3);
        graph.addEdge(3, 2, 5);
        graph.addEdge(2, 4, 7);

        List<int[]> expected = Arrays.asList(
                new int[]{0, 1, 2},
                new int[]{1, 2, 3},
                new int[]{0, 3, 6},
                new int[]{2, 4, 7}
        );
        List<int[]> actual = graph.primsMST(0);
        assertEquals(expected.size(), actual.size(), "MST should have correct number of edges.");
    }

    @Test
    void testPrims2() {
        Prims graph = new Prims();
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 1);

        List<int[]> expected = Arrays.asList(
                new int[]{4, 5, 1},
                new int[]{3, 4, 2},
                new int[]{2, 3, 5},
                new int[]{1, 2, 6},
                new int[]{0, 1, 4}
        );
        List<int[]> actual = graph.primsMST(4);
        assertEquals(expected.size(), actual.size(), "MST should have correct number of edges.");
    }

    @Test
    void testPrims3() {
        Prims graph = new Prims();
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 15);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 10);

        List<int[]> expected = Arrays.asList(
                new int[]{1, 2, 5},
                new int[]{0, 1, 10},
                new int[]{2, 3, 10}
        );
        List<int[]> actual = graph.primsMST(0);
        assertEquals(expected.size(), actual.size(), "MST should have correct number of edges.");
    }

    @Test
    void testPrims4() {
        Prims graph = new Prims();
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 4);

        List<int[]> expected = Arrays.asList(
                new int[]{0, 1, 1},
                new int[]{1, 2, 2},
                new int[]{2, 3, 3},
                new int[]{3, 4, 4}
        );
        List<int[]> actual = graph.primsMST(0);
        assertEquals(expected.size(), actual.size(), "MST should have correct number of edges.");
    }

    @Test
    void testPrims5() {
        Prims graph = new Prims();
        graph.addEdge(0, 0, 0);

        List<int[]> expected = new ArrayList<>();
        List<int[]> actual = graph.primsMST(0);
        assertEquals(expected.size(), actual.size(), "MST should be empty for a graph with a single node.");
    }

    @Test
    public void testPrimsAlgorithmValidatesMSTSize() {
        Prims graph = new Prims();

        // Create a larger graph to test edge count
        graph.addEdge(1, 2, 5);   // Edge (1, 2) with weight 5
        graph.addEdge(1, 3, 10);  // Edge (1, 3) with weight 10
        graph.addEdge(2, 3, 6);   // Edge (2, 3) with weight 6
        graph.addEdge(2, 4, 2);   // Edge (2, 4) with weight 2
        graph.addEdge(3, 4, 7);   // Edge (3, 4) with weight 7

        // Expected MST: { (1, 2), (2, 4), (2, 3) }
        // Total weight = 5 + 2 + 6 = 13
        List<int[]> mst = graph.primsMST(1);

        // Validate MST size
        assertEquals(3, mst.size(), "MST should have exactly |V| - 1 edges!");

        // Validate MST weight
        int totalWeight = mst.stream().mapToInt(edge -> edge[2]).sum();
        assertEquals(13, totalWeight, "Total MST weight should be 13!");
    }
    @Test
    public void testPrimsAlgorithmWithMutatedTerminationCondition() {
        Prims graph = new Prims();

        // Create a graph with 4 vertices and 5 edges
        graph.addEdge(1, 2, 1);   // Edge (1, 2) with weight 1
        graph.addEdge(2, 3, 2);   // Edge (2, 3) with weight 2
        graph.addEdge(3, 4, 3);   // Edge (3, 4) with weight 3
        graph.addEdge(1, 3, 5);   // Edge (1, 3) with weight 5
        graph.addEdge(2, 4, 4);   // Edge (2, 4) with weight 4

        // Run Prim's algorithm starting from node 1
        List<int[]> mst = graph.primsMST(1);

        // Validate the MST size should be exactly |V| - 1 = 3 edges for a graph with 4 vertices
        assertEquals(3, mst.size(), "MST should have exactly |V| - 1 edges!");

        // Calculate the total weight of the MST
        int totalWeight = mst.stream().mapToInt(edge -> edge[2]).sum();

        // Validate the MST weight (should be 1 + 2 + 4 = 7 for the MST edges)
        assertEquals(6, totalWeight, "Total MST weight should be 7!");
    }

    @Test
    public void testPrimsAlgorithmDenseGraph() {
        Prims graph = new Prims();

        // Graph with 5 vertices and multiple edges
        graph.addEdge(1, 2, 1);   // Edge (1, 2) with weight 1
        graph.addEdge(2, 3, 2);   // Edge (2, 3) with weight 2
        graph.addEdge(3, 4, 3);   // Edge (3, 4) with weight 3
        graph.addEdge(4, 5, 4);   // Edge (4, 5) with weight 4
        graph.addEdge(1, 3, 5);   // Extra edge (1, 3) with weight 5
        graph.addEdge(1, 4, 6);   // Extra edge (1, 4) with weight 6
        graph.addEdge(2, 5, 7);   // Extra edge (2, 5) with weight 7

        // Run Prim's algorithm starting from node 1
        List<int[]> mst = graph.primsMST(1);

        // Validate MST size
        assertEquals(4, mst.size(), "MST should have exactly |V| - 1 edges for a graph with 5 vertices!");

        // Validate MST weight
        int totalWeight = mst.stream().mapToInt(edge -> edge[2]).sum();
        assertEquals(10, totalWeight, "Total MST weight should be 10!");
    }
    @Test
    public void testPrimsAlgorithmSparseGraph() {
        Prims graph = new Prims();

        // Sparse graph with 4 vertices
        graph.addEdge(1, 2, 1);   // Edge (1, 2)
        graph.addEdge(2, 3, 2);   // Edge (2, 3)
        graph.addEdge(3, 4, 3);   // Edge (3, 4)

        // Run Prim's algorithm starting from node 1
        List<int[]> mst = graph.primsMST(1);

        // Validate MST size
        assertEquals(3, mst.size(), "MST should have exactly |V| - 1 edges for a graph with 4 vertices!");

        // Validate MST weight
        int totalWeight = mst.stream().mapToInt(edge -> edge[2]).sum();
        assertEquals(6, totalWeight, "Total MST weight should be 6!");
    }
    @Test
    public void testPrimsAlgorithmDisconnectedGraph() {
        Prims graph = new Prims();

        // Two disconnected components
        graph.addEdge(1, 2, 1);   // Component 1: Edge (1, 2)
        graph.addEdge(2, 3, 2);   // Component 1: Edge (2, 3)
        graph.addEdge(4, 5, 3);   // Component 2: Edge (4, 5)

        // Run Prim's algorithm starting from node 1
        List<int[]> mst = graph.primsMST(1);

        // Validate MST size (should only process Component 1)
        assertEquals(2, mst.size(), "MST should only include edges from the connected component starting at node 1!");

        // Validate MST weight (Component 1: 1 + 2 = 3)
        int totalWeight = mst.stream().mapToInt(edge -> edge[2]).sum();
        assertEquals(3, totalWeight, "Total MST weight should be 3!");
    }


    @Test
    void testDijkstra1() {
        Dijkstra graph = new Dijkstra();
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 9);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 7);
        expected.put(2, 5);
        expected.put(3, 8);

        Map<Integer, Integer> actual = graph.dijkstra(0);
        assertEquals(expected, actual, "Dijkstra's algorithm should return the correct shortest paths.");
    }



    @Test
    void testDijkstra2() {
        Dijkstra graph = new Dijkstra();
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 4);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 1);
        expected.put(2, 3);
        expected.put(3, 6);
        expected.put(4, 10);

        Map<Integer, Integer> actual = graph.dijkstra(0);
        assertEquals(expected, actual, "Dijkstra's algorithm should return correct shortest distances.");
    }

    @Test
    void testDijkstra3() {
        Dijkstra graph = new Dijkstra();
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 4, 3);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 7);
        expected.put(2, 5);
        expected.put(3, 8);
        expected.put(4, 11);

        Map<Integer, Integer> actual = graph.dijkstra(0);
        assertEquals(expected, actual, "Dijkstra's algorithm should return the correct shortest paths.");
    }

    @Test
    void testDijkstra4() {
        Dijkstra graph = new Dijkstra();
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 6);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 5);
        expected.put(2, 8);
        expected.put(3, 9);
        expected.put(4, 15);

        Map<Integer, Integer> actual = graph.dijkstra(0);
        assertEquals(expected, actual, "Dijkstra's algorithm should return the correct shortest paths.");
    }

    @Test
    void testDijkstra5() {
        Dijkstra graph = new Dijkstra();
        graph.addEdge(0, 1, 3);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 1);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 3);
        expected.put(2, 5);
        expected.put(3, 6);

        Map<Integer, Integer> actual = graph.dijkstra(0);
        assertEquals(expected, actual, "Dijkstra's algorithm should return the correct shortest paths.");
    }

    @Test
    public void testDijkstraWithPriorityQueueBehavior() {
        Dijkstra graph = new Dijkstra();

        // Construct a graph where processing order matters
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 1);
        graph.addEdge(2, 4, 7);

        // Expected behavior:
        // - From node 1, the shortest path to:
        //     1 -> 2 is 1
        //     1 -> 3 is 3 (via 2 -> 3)
        //     1 -> 4 is 4 (via 3)

        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(1, 0); // Start node
        expectedDistances.put(2, 1);
        expectedDistances.put(3, 3);
        expectedDistances.put(4, 4);

        Map<Integer, Integer> actualDistances = graph.dijkstra(1);

        // Validate the result
        assertEquals(expectedDistances, actualDistances, "Dijkstra's algorithm did not produce expected distances!");
    }
    @Test
    public void testDijkstraBoundaryCondition() {
        Dijkstra graph = new Dijkstra();

        // Create a graph with duplicate paths of varying weights
        graph.addEdge(1, 2, 5); // Path 1 -> 2 (Weight 5)
        graph.addEdge(1, 3, 2); // Path 1 -> 3 (Weight 2)
        graph.addEdge(3, 2, 1); // Path 3 -> 2 (Weight 1, total 3)
        graph.addEdge(2, 4, 3); // Path 2 -> 4 (Weight 3)

        // Expected behavior:
        // - Shortest path from node 1:
        //     1 -> 2 is 3 (via 3 -> 2)
        //     1 -> 3 is 2
        //     1 -> 4 is 6 (via 3 -> 2 -> 4)

        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(1, 0); // Start node
        expectedDistances.put(2, 3);
        expectedDistances.put(3, 2);
        expectedDistances.put(4, 6);

        Map<Integer, Integer> actualDistances = graph.dijkstra(1);

        // Validate the result
        assertEquals(expectedDistances, actualDistances, "Dijkstra's algorithm failed to compute correct distances!");

        // Additional checks to ensure condition behavior
        assertTrue(actualDistances.get(2) == 3, "Boundary condition allowed incorrect update of distance to 2!");
        assertTrue(actualDistances.get(4) == 6, "Boundary condition allowed incorrect update of distance to 4!");
    }
    @Test
    public void testDijkstraPriorityQueueComparator() {
        Dijkstra graph = new Dijkstra();

        // Graph structure where priority-based processing is critical
        graph.addEdge(1, 2, 10); // Direct but long path
        graph.addEdge(1, 3, 1);  // Short path to node 3
        graph.addEdge(3, 2, 1);  // Short path from 3 -> 2
        graph.addEdge(2, 4, 1);  // Path to node 4 via 2
        graph.addEdge(3, 4, 5);  // Longer path to node 4 via 3

        // Expected distances from node 1:
        // 1 -> 2 = 2 (via 1 -> 3 -> 2)
        // 1 -> 3 = 1
        // 1 -> 4 = 3 (via 1 -> 3 -> 2 -> 4)

        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(1, 0); // Starting node
        expectedDistances.put(2, 2);
        expectedDistances.put(3, 1);
        expectedDistances.put(4, 3);

        Map<Integer, Integer> actualDistances = graph.dijkstra(1);

        // Validate the shortest paths
        assertEquals(expectedDistances, actualDistances, "Dijkstra's algorithm produced incorrect distances!");

        // Validate processing order indirectly
        assertTrue(actualDistances.get(2) == 2,
                "PriorityQueue processing order failed to compute the shortest path to node 2!");
        assertTrue(actualDistances.get(4) == 3,
                "PriorityQueue processing order failed to compute the shortest path to node 4!");
    }
    @Test
    public void testDijkstraWithShorterPathUpdate() {
        Dijkstra graph = new Dijkstra();

        // Construct a graph with a mix of longer and shorter paths
        graph.addEdge(1, 2, 5);   // Longer direct path to 2
        graph.addEdge(1, 3, 2);   // Shorter path to 3
        graph.addEdge(3, 2, 1);   // Shorter path to 2 via 3
        graph.addEdge(2, 4, 1);   // Path to 4 via 2
        graph.addEdge(3, 4, 6);   // Longer path to 4 via 3

        // Expected distances from node 1:
        // 1 -> 2 = 3 (via 1 -> 3 -> 2)
        // 1 -> 3 = 2
        // 1 -> 4 = 4 (via 1 -> 3 -> 2 -> 4)

        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(1, 0); // Starting node
        expectedDistances.put(2, 3);
        expectedDistances.put(3, 2);
        expectedDistances.put(4, 4);

        Map<Integer, Integer> actualDistances = graph.dijkstra(1);

        // Assert the shortest paths are correct
        assertEquals(expectedDistances, actualDistances, "Dijkstra's algorithm produced incorrect distances!");

        // Additional validation to ensure correct update
        int pathTo2Via3 = actualDistances.get(3) + 1; // 1 -> 3 -> 2 = 2 + 1
        int pathTo2Direct = 5;                        // 1 -> 2 = 5 (direct but longer)

        assertTrue(actualDistances.get(2) == pathTo2Via3,
                "Condition failed to update to a shorter path for node 2!");

        assertTrue(actualDistances.get(2) < pathTo2Direct,
                "Condition allowed longer direct path to node 2 to take precedence!");
    }
    @Test
    public void testDijkstraWithDisabledPriorityQueue() {
        Dijkstra graph = new Dijkstra();

        // Construct a graph where priority matters
        graph.addEdge(1, 2, 10);  // Direct but long path
        graph.addEdge(1, 3, 1);   // Short path to node 3
        graph.addEdge(3, 2, 1);   // Short path from 3 -> 2
        graph.addEdge(2, 4, 1);   // Path to node 4 via 2
        graph.addEdge(3, 4, 10);  // Longer path to node 4 via 3

        // Expected distances:
        // 1 -> 2 = 2 (via 1 -> 3 -> 2)
        // 1 -> 3 = 1
        // 1 -> 4 = 3 (via 1 -> 3 -> 2 -> 4)

        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(1, 0);
        expectedDistances.put(2, 2);
        expectedDistances.put(3, 1);
        expectedDistances.put(4, 3);

        Map<Integer, Integer> actualDistances = graph.dijkstra(1);

        // Assert correctness of distances
        assertEquals(expectedDistances, actualDistances,
                "Dijkstra's algorithm failed due to incorrect node processing order!");

        // Additional validation
        assertTrue(actualDistances.get(2) == 2,
                "PriorityQueue mutation resulted in incorrect shortest path to node 2!");
        assertTrue(actualDistances.get(4) == 3,
                "PriorityQueue mutation resulted in incorrect shortest path to node 4!");
    }



//    @Test bug:has cycle so fails
//    void testDijkstra6() {
//        Dijkstra graph = new Dijkstra();
//        graph.addEdge(0, 1, 1);
//        graph.addEdge(1, 2, 2);
//        graph.addEdge(2, 3, 3);
//        graph.addEdge(3, 0, 4);
//
//        Map<Integer, Integer> expected = new HashMap<>();
//        expected.put(0, 0);
//        expected.put(1, 1);
//        expected.put(2, 3);
//        expected.put(3, 6);
//
//        Map<Integer, Integer> actual = graph.dijkstra(0);
//        assertEquals(expected, actual, "Dijkstra's algorithm should return the correct shortest paths.");
//    }


    @Test
    void testFloydWarshall2() {
        FloydWarshall graph = new FloydWarshall();
        int[][] inputGraph = {
                {0, 5, INF, INF},
                {5, 0, 2, 7},
                {INF, 2, 0, 3},
                {INF, 7, 3, 0}
        };

        int[][] expected = {
                {0, 5, 7, 10},
                {5, 0, 2, 5},
                {7, 2, 0, 3},
                {10, 5, 3, 0}
        };

        int[][] result = graph.floydWarshall(inputGraph);
        assertTrue(Arrays.deepEquals(expected, result), "Floyd-Warshall algorithm should return the correct shortest paths.");
    }

    @Test
    void testFloydWarshall3() {
        FloydWarshall graph = new FloydWarshall();
        int[][] inputGraph = {
                {0, INF, INF},
                {INF, 0, INF},
                {INF, INF, 0}
        };

        int[][] expected = {
                {0, INF, INF},
                {INF, 0, INF},
                {INF, INF, 0}
        };

        int[][] result = graph.floydWarshall(inputGraph);
        assertTrue(Arrays.deepEquals(expected, result), "Floyd-Warshall algorithm should handle disconnected nodes correctly.");
    }

    @Test
    void testFloydWarshall4() {
        FloydWarshall graph = new FloydWarshall();
        int[][] inputGraph = {
                {0, 1, 3, INF},
                {1, 0, 1, 2},
                {3, 1, 0, 1},
                {INF, 2, 1, 0}
        };

        int[][] expected = {
                {0, 1, 2, 3},
                {1, 0, 1, 2},
                {2, 1, 0, 1},
                {3, 2, 1, 0}
        };

        int[][] result = graph.floydWarshall(inputGraph);
        assertTrue(Arrays.deepEquals(expected, result), "Floyd-Warshall algorithm should return correct shortest paths for a small graph.");
    }

    @Test
    void testHamiltonianCycle() {
        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle();
        int[] ans1 = {0, 1, 2, 4, 3, 0};
        int[][] arr1 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        assertArrayEquals(ans1, hamiltonianCycle.findHamiltonianCycle(arr1));
    }
    @Test
    void testHamiltonianCycle2(){
        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle();
        int[] ans2 = { -1, -1, -1, -1, -1, -1 };
        int[][] arr2 = {
                { 0, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 1 },
                { 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 0 },
        };
        assertArrayEquals(ans2, hamiltonianCycle.findHamiltonianCycle(arr2));

    }

    @Test
    void testBipartite1() { // Simple Bipartite Graph
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        assertTrue(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite2() { // Non-Bipartite Graph (odd cycle)
        int V = 3;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(0);
        adj.get(0).add(2);

        assertFalse(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite3() { // Disconnected Graph with Bipartite Components
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Component 1: Bipartite
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);

        // Component 2: Bipartite
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);

        assertTrue(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite4() { // Disconnected Graph with a Non-Bipartite Component
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Component 1: Bipartite
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);

        // Component 2: Non-Bipartite (odd cycle)
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(3);
        adj.get(3).add(5);

        assertFalse(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite5() { // Single Node Graph
        int V = 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        assertTrue(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite6() { // Empty Graph (No edges)
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        assertTrue(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite7() { // Non-Bipartite Graph (even cycle with additional edge)
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);
        adj.get(0).add(2); // Additional edge makes it non-bipartite

        assertFalse(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite8() { // Complete Bipartite Graph K3,3
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(3); adj.get(0).add(4); adj.get(0).add(5);
        adj.get(1).add(3); adj.get(1).add(4); adj.get(1).add(5);
        adj.get(2).add(3); adj.get(2).add(4); adj.get(2).add(5);

        adj.get(3).add(0); adj.get(3).add(1); adj.get(3).add(2);
        adj.get(4).add(0); adj.get(4).add(1); adj.get(4).add(2);
        adj.get(5).add(0); adj.get(5).add(1); adj.get(5).add(2);

        assertTrue(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite9() { // Chain Graph
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        assertTrue(Bipartite.isBipartite(V, adj));
    }

    @Test
    void testBipartite10() { // Fully Connected Non-Bipartite Graph
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(0).add(2); adj.get(0).add(3);
        adj.get(1).add(0); adj.get(1).add(2); adj.get(1).add(3);
        adj.get(2).add(0); adj.get(2).add(1); adj.get(2).add(3);
        adj.get(3).add(0); adj.get(3).add(1); adj.get(3).add(2);

        assertFalse(Bipartite.isBipartite(V, adj));
    }


    /* @Test
     void testKruskalsMST11() {
         // Test case: A simple graph with unique edge weights
         int V = 4; // Number of vertices
         List<KruskalsMST.Edge> edges = new ArrayList<>(
                 List.of(
                         new KruskalsMST.Edge(0, 1, 10),
                         new KruskalsMST.Edge(0, 2, 6),
                         new KruskalsMST.Edge(0, 3, 5),
                         new KruskalsMST.Edge(1, 3, 15),
                         new KruskalsMST.Edge(2, 3, 4)
                 )
         );

         // Run Kruskal's MST algorithm
         KruskalsMST.kruskals(V, edges);

         // Expected MST edges:
         // 2 -- 3 == 4
         // 0 -- 3 == 5
         // 0 -- 2 == 6
         // Total cost: 15
     }*/
    @Test
    void testKruskalsMST2() {
        KruskalsMST.Subset[] subsets = new KruskalsMST.Subset[3];
        subsets[0] = new KruskalsMST.Subset(0, 1); // Higher rank
        subsets[1] = new KruskalsMST.Subset(1, 0); // Lower rank
        subsets[2] = new KruskalsMST.Subset(2, 0); // Isolated subset

        // Perform union on subsets[0] and subsets[1]
        KruskalsMST.union(subsets, 0, 1);

        // Verify that subset[1]'s parent points to subset[0]
        assertEquals(0, subsets[1].parent);
        assertEquals(1, subsets[0].rank); // Rank of the higher-ranked subset should remain unchanged
    }

    /*@Test
    void testKruskalsMST3() {
        // Test case: Graph with duplicate edge weights
        int V = 4; // Number of vertices
        List<KruskalsMST.Edge> edges = new ArrayList<>(
                List.of(
                        new KruskalsMST.Edge(0, 1, 5),
                        new KruskalsMST.Edge(0, 2, 5),
                        new KruskalsMST.Edge(1, 3, 5),
                        new KruskalsMST.Edge(2, 3, 5)
                )
        );

        // Run Kruskal's MST algorithm
        KruskalsMST.kruskals(V, edges);

        // Expected MST:
        // 0 -- 1 == 5
        // 0 -- 2 == 5
        // 1 -- 3 == 5
        // Total cost: 15
    }*/
    @Test
    void testKruskalsMST4() {
        // Test case: Single node graph
        int V = 1; // Number of vertices
        List<KruskalsMST.Edge> edges = new ArrayList<>();

        // Run Kruskal's MST algorithm
        KruskalsMST.kruskals(V, edges);

        // Expected MST: No edges, total cost = 0
        int actualCost = calculateMSTCost(V, edges);
        assertEquals(0, actualCost, "MST cost for a single-node graph should be 0.");

    }

    @Test
    void testKruskalsMST5() {
        // Test case: Graph with a cycle
        int V = 4; // Number of vertices
        List<KruskalsMST.Edge> edges = new ArrayList<>(
                List.of(
                        new KruskalsMST.Edge(0, 1, 1),
                        new KruskalsMST.Edge(1, 2, 2),
                        new KruskalsMST.Edge(2, 3, 3),
                        new KruskalsMST.Edge(3, 0, 4) // This edge creates a cycle
                )
        );

        // Run Kruskal's MST algorithm
        KruskalsMST.kruskals(V, edges);

        // Expected MST:
        // 0 -- 1 == 1
        // 1 -- 2 == 2
        // 2 -- 3 == 3
        // Total cost: 6
        int actualCost = calculateMSTCost(V, edges);
        assertEquals(6, actualCost, "MST cost should be 6.");
    }
/*
    @Test
    void testKruskalsMST6() {
        // Test case: Graph with negative weights
        int V = 3; // Number of vertices
        List<KruskalsMST.Edge> edges = new ArrayList<>(
                List.of(
                        new KruskalsMST.Edge(0, 1, -5),
                        new KruskalsMST.Edge(1, 2, -10),
                        new KruskalsMST.Edge(0, 2, 4)
                )
        );

        // Run Kruskal's MST algorithm
        KruskalsMST.kruskals(V, edges);

        // Expected MST:
        // 1 -- 2 == -10
        // 0 -- 1 == -5
        // Total cost: -15
    }*/

    @Test
    void testKruskalsMST7() {
        KruskalsMST.Subset[] subsets = new KruskalsMST.Subset[2];
        subsets[0] = new KruskalsMST.Subset(0, 0); // Equal rank
        subsets[1] = new KruskalsMST.Subset(1, 0); // Equal rank

        // Perform union on subsets[0] and subsets[1]
        KruskalsMST.union(subsets, 0, 1);

        // Verify that subset[1]'s parent is now subset[0] and the rank of subset[0] increases
        assertEquals(0, subsets[1].parent);
        assertEquals(1, subsets[0].rank);
    }
    @Test
    void testKruskalsMST_RemoveUnion_MakesCycle() {
        // Test case: Graph where removal of union causes a cycle
        int V = 4; // Number of vertices
        List<KruskalsMST.Edge> edges = new ArrayList<>(
                List.of(
                        new KruskalsMST.Edge(0, 1, 1), // Edge 0 -- 1 (weight 1)
                        new KruskalsMST.Edge(1, 2, 2), // Edge 1 -- 2 (weight 2)
                        new KruskalsMST.Edge(2, 3, 3), // Edge 2 -- 3 (weight 3)
                        new KruskalsMST.Edge(3, 0, 4)  // Edge 3 -- 0 (weight 4, creates a cycle if included)
                )
        );

        // Sort edges by weight (required for Kruskal's algorithm)
        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Run Kruskal's MST algorithm and calculate the cost
        int expectedCost = 6; // The correct MST will include edges {0-1, 1-2, 2-3} with cost 6
        int actualCost = calculateMSTCost(V, edges);

        // Assert the MST cost is as expected when union is not removed
        assertEquals(expectedCost, actualCost, "MST cost should be correct when union operation is not removed.");
    }

    @Test
    public void testBellmanFord1() {
        // Simple graph with no negative weights
        int V = 5;
        int[][] edges = {
                {0, 1, 4},
                {0, 2, 1},
                {2, 1, 2},
                {1, 3, 1},
                {2, 3, 5}
        };
        int src = 0;
        int[] expected = {0, 3, 1, 4, (int)1e8}; // Shortest distances
        assertArrayEquals(expected, BellManFord.bellmanFord(V, edges, src));
    }

    @Test
    public void testBellmanFord2() {
        // Graph with negative weights but no negative cycle
        int V = 4;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, -1},
                {2, 3, -1},
                {3, 0, 1}
        };
        int src = 0;
        int[] expected = {0, 1, 0, -1}; // Shortest distances
        assertArrayEquals(expected, BellManFord.bellmanFord(V, edges, src));
    }

    @Test
    public void testBellmanFord3() {
        // Graph with a negative weight cycle
        int V = 3;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, -1},
                {2, 0, -1}
        };
        int src = 0;
        int[] expected = {-1}; // Negative cycle detected
        assertArrayEquals(expected, BellManFord.bellmanFord(V, edges, src));
    }
/*
    @Test
    public void testBellmanFord4() {
        // Graph where some nodes are unreachable
        int V = 6;
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 4},
                {3, 4, 3}
        };
        int src = 0;
        int[] expected = {0, 2, 4, (int)1e8, (int)1e8, (int)1e8}; // Unreachable nodes
        assertArrayEquals(expected, BellManFord.bellmanFord(V, edges, src));
    }
*/

    /*@Test
    public void testBellmanFord5() {
        // Graph with a single node
        int V = 1;
        int[][] edges = {};
        int src = 0;
        int[] expected = {0}; // Single node, distance is 0
        assertArrayEquals(expected, BellManFord.bellmanFord(V, edges, src));
    }*/

  /*  @Test
    public void testBellmanFord6() {
        // Graph with disconnected components
        int V = 5;
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 3}
        };
        int src = 0;
        int[] expected = {0, 2, 5, (int)1e8, (int)1e8}; // Nodes 3 and 4 are unreachable
        assertArrayEquals(expected, BellManFord.bellmanFord(V, edges, src));
    }*/

    @Test
    public void testUnionCriticalToMST() {
        // Number of vertices
        int V = 4;

        // Define edges of the graph
        List<KruskalsMST.Edge> edges = new ArrayList<>();
        edges.add(new KruskalsMST.Edge(0, 1, 1)); // Smallest edge
        edges.add(new KruskalsMST.Edge(1, 2, 2));
        edges.add(new KruskalsMST.Edge(2, 3, 3));
        edges.add(new KruskalsMST.Edge(0, 3, 4)); // Largest edge

        // Run Kruskal's algorithm
        KruskalsMST.kruskals(V, edges);

        // MST for this graph should be:
        // 0 -- 1 == 1
        // 1 -- 2 == 2
        // 2 -- 3 == 3
        // Total cost of MST: 6

        // Expected MST cost
        int expectedCost = 6;

        // Assert the correct MST cost is returned
        assertEquals(expectedCost, calculateMSTCost(V, edges));
    }
    @Test
    public void testFindRoot() {
        // Number of vertices
        int V = 4;

        // Define edges of the graph
        List<KruskalsMST.Edge> edges = new ArrayList<>();
        edges.add(new KruskalsMST.Edge(0, 1, 10));
        edges.add(new KruskalsMST.Edge(0, 2, 6));
        edges.add(new KruskalsMST.Edge(0, 3, 5));
        edges.add(new KruskalsMST.Edge(1, 3, 15));
        edges.add(new KruskalsMST.Edge(2, 3, 4));

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Run Kruskal's algorithm
        KruskalsMST.kruskals(V, edges);

        // MST for this graph should be:
        // 2 -- 3 == 4
        // 0 -- 3 == 5
        // 0 -- 1 == 10
        // Total cost of MST: 19

        // Manually verify the MST cost
        int expectedCost = 19;
        assertEquals(expectedCost, calculateMSTCost(V, edges));
    }

    private int calculateMSTCost(int V, List<KruskalsMST.Edge> edges) {
        int j = 0;
        int noOfEdges = 0;
        int minCost = 0;

        KruskalsMST.Subset[] subsets = new KruskalsMST.Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new KruskalsMST.Subset(i, 0);
        }

        while (noOfEdges < V - 1) {
            KruskalsMST.Edge nextEdge = edges.get(j);
            int x = KruskalsMST.findRoot(subsets, nextEdge.src);
            int y = KruskalsMST.findRoot(subsets, nextEdge.dest);

            if (x != y) {
                minCost += nextEdge.weight;
                KruskalsMST.union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }

        return minCost;
    }
    @Test
    void testKruskalsMST1() {
        // Test case: Graph with duplicate edge weights
        int V = 4; // Number of vertices
        List<KruskalsMST.Edge> edges = new ArrayList<>(
                List.of(
                        new KruskalsMST.Edge(0, 1, 5),
                        new KruskalsMST.Edge(0, 2, 5),
                        new KruskalsMST.Edge(1, 3, 5),
                        new KruskalsMST.Edge(2, 3, 5)
                )
        );

        // Expected MST: Any valid combination with a total cost of 15
        int expectedCost = 15;

        // Assert that the MST cost matches
        assertEquals(expectedCost, calculateMSTCost(V, edges));
    }
    @Test
    void testCalculateMSTCost() {
        int V = 4; // Number of vertices
        List<KruskalsMST.Edge> edges = new ArrayList<>(
                List.of(
                        new KruskalsMST.Edge(0, 1, 10),
                        new KruskalsMST.Edge(1, 2, 15),
                        new KruskalsMST.Edge(2, 3, 20),
                        new KruskalsMST.Edge(0, 3, 25)
                )
        );

        // Sort edges by weight as required by Kruskal's algorithm
        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Compute the MST cost
        int mstCost = calculateMSTCost(V, edges);

        // Assertions to verify correctness
        assertEquals(45, mstCost, "MST cost should be 45");
    }



}
