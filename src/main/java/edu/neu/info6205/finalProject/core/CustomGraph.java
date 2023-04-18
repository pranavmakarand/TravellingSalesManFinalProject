package edu.neu.info6205.finalProject.core;

import java.util.ArrayList;
import java.util.List;

public class CustomGraph {
    private List<Node> nodes;
    private List<Edge> edges;

    public CustomGraph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public int degree(Node node) {
		 int degree = 0;
		    for (Edge edge : edges) {
		        if (edge.getA() == node || edge.getB() == node) {
		            degree++;
		        }
		    }
		    return degree;
	}
	
	public Edge getEdge(Node a, Node b) {
		for(Edge e: edges) {
			if(e.getA() == a && e.getB() == b) {
				return e;
			}
		}
		return null;
		
	}
    
}
