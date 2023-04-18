package edu.neu.info6205.finalProject.GeneticAlgorithm;

import java.util.List;

import edu.neu.info6205.finalProject.core.Node;
import edu.neu.info6205.finalProject.util.Distance;

public class Chromosome implements Comparable<Chromosome>{
	private List<Node> nodes;
    private double fitness;

    public Chromosome(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }
    public double getFitness() {
        return fitness;
    }

    public void calculateFitness() {
        double distance = 0;
        for (int i = 0; i < nodes.size() - 1; i++) {
            distance +=  Distance.measureDistance(nodes.get(i),nodes.get(i + 1));
        }
        fitness = 1 / distance;
    }

    @Override
    public int compareTo(Chromosome o) {
        return Double.compare(o.getFitness(), fitness);
    }
}
