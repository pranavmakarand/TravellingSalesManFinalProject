package edu.neu.info6205.finalProject.GraphVisualizer;
import edu.neu.csye6205.finalProject.Paurush.Edge;
import edu.neu.csye6205.finalProject.Paurush.CustomGraph;
import edu.neu.csye6205.finalProject.Paurush.Node;
import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.decorators.*;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import java.awt.*;
import java.util.function.Function;

import javax.swing.*;
public class MSTVisualizer {
	public static void visualizeMST(CustomGraph mst) {
        // Create a GraphStream graph based on the MST graph
        SingleGraph graphStreamGraph = new SingleGraph("MST");
        for (Node node : mst.getNodes()) {
            graphStreamGraph.addNode(node.getId());
        }
        int count = 0;
        for (Edge edge : mst.getEdges()) {
        	count++;
            graphStreamGraph.addEdge(String.valueOf(count), edge.getA().getId(), edge.getB().getId())
                    .setAttribute("weight", edge.getEdgeWeight());
        }

        // Set up the visualization settings
        graphStreamGraph.setAttribute("ui.stylesheet", "edge { size: 2px; }");
        Viewer viewer = graphStreamGraph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

        // Wait for the user to close the visualization window
        while (viewer.getDefaultView().isOpaque()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}