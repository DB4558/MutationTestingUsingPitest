package GraphAlgorithms;

import org.example.GraphAlgorithms.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestAllGraph {

    private static final int INF = Integer.MAX_VALUE;




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
