package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class BarabasiAlbert {

    private UndirectedSparseGraph<Integer, String> graph;

    public BarabasiAlbert(int numberOfNodes, int startingNumberOfNodes, double probability, int newConnections) {
        if (newConnections <= 0) throw new IllegalArgumentException("new node must add at least 1 new connection");

        this.graph = new UndirectedSparseGraph<>();
        List<Integer> vertices = new ArrayList<>();
        List<Integer> degreeList = new ArrayList<>();
        Random randomGenerator = new Random();

        for (int i = 0; i < startingNumberOfNodes; i++) {
            graph.addVertex(i);
            vertices.add(i);
            for (int j = i + 1; j < startingNumberOfNodes; j++) {
                if (randomGenerator.nextDouble() <= probability) {
                    String edgeLabel = i + "-" + j;
                    graph.addEdge(edgeLabel, i, j, EdgeType.UNDIRECTED);
                }
            }
        }

        for (Integer vertex : vertices) {
            for (int i = 0; i < graph.degree(vertex); i++) {
                degreeList.add(vertex);
            }
        }

        for (int i = startingNumberOfNodes; i < numberOfNodes; i++) {
            graph.addVertex(i);

            for (int j = 0; j < newConnections; j++) {
                int neighborIndex = randomGenerator.nextInt(degreeList.size());
                Integer neighbor = degreeList.get(neighborIndex);
                String edgeLabel = i + "-" + neighbor;
                graph.addEdge(edgeLabel, i, neighbor, EdgeType.UNDIRECTED);
                degreeList.add(neighbor);
            }

            vertices.add(i);
            for (int j = 0; j < graph.degree(i); j++) {
                degreeList.add(i);
            }
        }
    }

    public UndirectedSparseGraph<Integer, String> getGraph() {
        return graph;
    }

    
}
