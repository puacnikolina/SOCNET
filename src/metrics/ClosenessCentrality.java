package metrics;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.algorithms.shortestpath.UnweightedShortestPath;
import java.util.HashMap;
import java.util.Map;

public class ClosenessCentrality {
	
    private UndirectedSparseGraph<Integer, String> graph;
    private Map<Integer, Double> closenessMap;

    public ClosenessCentrality(UndirectedSparseGraph<Integer, String> graph) {
        this.graph = graph;
        this.closenessMap = new HashMap<Integer, Double>();
        evaluate();
    }

    private void evaluate() {
        int numOfVertices = graph.getVertexCount();
        for (Integer vertex : graph.getVertices()) {
            UnweightedShortestPath<Integer, String> udsp = new UnweightedShortestPath<>(graph);
            Map<Integer, Number> vertexDistances = udsp.getDistanceMap(vertex);
            double distance = 0;
            for (Number value : vertexDistances.values()) {
                distance += value.doubleValue();
            }
            double closeness = (numOfVertices - 1) / distance;
            closenessMap.put(vertex, closeness);
        }
    }
    
    public Map<Integer, Double> getClosenessMap() {
        return closenessMap;
    }
}
