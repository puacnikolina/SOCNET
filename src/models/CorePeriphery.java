package models;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CorePeriphery {
	
    private UndirectedSparseGraph<Integer, String> graph;

    public CorePeriphery(int n, double coreNodes, double coreProbability,
                         double peripheryProbability, double corePeripheryProbability) {

        this.graph = new UndirectedSparseGraph<>();
        
        int numCoreNodes = (int) (n * coreNodes);
        List<Integer> coreVertices = new ArrayList<>(numCoreNodes);
        List<Integer> peripheryVertices = new ArrayList<>(n - numCoreNodes);

        for (int i = 0; i < numCoreNodes; i++) {
            graph.addVertex(i);
            coreVertices.add(i);
        }

        for (int i = numCoreNodes; i < n; i++) {
            graph.addVertex(i);
            peripheryVertices.add(i);
        }

        Random rnd = new Random();
        for (int i : coreVertices) {
            for (int j : coreVertices) {
                if (i < j && rnd.nextDouble() <= coreProbability) {
                    graph.addEdge(i + "-" + j, i, j, EdgeType.UNDIRECTED);
                }
            }
        }

        for (int i : peripheryVertices) {
            for (int j : peripheryVertices) {
                if (i < j && rnd.nextDouble() <= peripheryProbability) {
                    graph.addEdge(i + "-" + j, i, j, EdgeType.UNDIRECTED);
                }
            }
        }

        for (int i : coreVertices) {
            for (int j : peripheryVertices) {
                if (rnd.nextDouble() <= corePeripheryProbability) {
                    graph.addEdge(i + "-" + j, i, j, EdgeType.UNDIRECTED);
                }
            }
        }
    }

    public UndirectedSparseGraph<Integer, String> getGraph() {
        return graph;
    }
}