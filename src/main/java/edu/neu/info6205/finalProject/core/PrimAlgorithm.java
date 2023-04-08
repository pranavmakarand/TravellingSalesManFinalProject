package edu.neu.info6205.finalProject.core;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimAlgorithm {

    public static CustomGraph findMinimumSpanningTree(CustomGraph graph) {
        // Create a new graph to hold the minimum spanning tree
        CustomGraph minimumSpanningTree = new CustomGraph();

        // Create a set to keep track of the visited nodes
        Set<Node> visitedNodes = new HashSet<>();

        // Add the first node to the visited set
        visitedNodes.add(graph.getNodes().get(0));
        minimumSpanningTree.addNode(graph.getNodes().get(0));

        // Create a priority queue to store the edges in ascending order by weight
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(graph.getEdges().size(),
                (a, b) -> Double.compare(a.getEdgeWeight(), b.getEdgeWeight()));

        // Add all the edges connected to the first node to the priority queue
        for (Edge edge : graph.getEdges()) {
            if (edge.getA().equals(visitedNodes.iterator().next()) || edge.getB().equals(visitedNodes.iterator().next())) {
                priorityQueue.offer(edge);
            }
        }

        // Iterate until all nodes have been visited
      

        return minimumSpanningTree;
    }
}
