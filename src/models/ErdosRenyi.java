package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class ErdosRenyi {

    private UndirectedSparseGraph<Integer, String> graph;

    
    public ErdosRenyi(int numberOfNodes, double probability) {
        graph = new UndirectedSparseGraph<>();
        List<Integer> vertices = new ArrayList<>();

        
        for (int i = 0; i < numberOfNodes; i++) {
            graph.addVertex(i);
            vertices.add(i);
        }

        Random randomGenerator = new Random();

      
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = i + 1; j < numberOfNodes; j++) {
                if (randomGenerator.nextDouble() <= probability) {
                    String edgeLabel = i + "-" + j;
                    graph.addEdge(edgeLabel, i, j, EdgeType.UNDIRECTED);
                }
            }
        }
    }

    public UndirectedSparseGraph<Integer, String> getGraph() {
        return graph;
    }

}