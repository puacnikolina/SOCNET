package decomposition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

public class StraightForward<V, E> {

    private UndirectedSparseGraph<V, E> graph;
    private UndirectedSparseGraph<V, E> graphCopy;

    public StraightForward(UndirectedSparseGraph<V, E> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("graph is null");
        }
        if (graph.getVertexCount() == 0) {
            throw new IllegalArgumentException("graph doesn't have any nodes");
        }

        this.graph = graph;
        this.graphCopy = new UndirectedSparseGraph<>();
        for (V vertex : graph.getVertices()) {
            this.graphCopy.addVertex(vertex);
        }
        for (E edge : graph.getEdges()) {
            Pair<V> endpoints = graph.getEndpoints(edge);
            this.graphCopy.addEdge(edge, endpoints.getFirst(), endpoints.getSecond(), EdgeType.UNDIRECTED);
        }
    }

    public Map<V, Integer> decomposition() {
        Map<V, Integer> shellIndex = new HashMap<>();
        int currentK = 1;

        while (!graphCopy.getVertices().isEmpty()) {
            boolean removed = false;

            List<V> toRemove = new ArrayList<>();
            for (V vertex : graphCopy.getVertices()) {
                if (graphCopy.degree(vertex) < currentK) {
                    toRemove.add(vertex);
                    removed = true;
                }
            }

            for (V vertex : toRemove) {
                shellIndex.put(vertex, currentK - 1);
                for (V neighbor : new ArrayList<>(graphCopy.getNeighbors(vertex))) {
                    graphCopy.removeEdge(graphCopy.findEdge(vertex, neighbor));
                }
                graphCopy.removeVertex(vertex);
            }

            if (!removed) {
                currentK++;
            }
        }

        return shellIndex;
    }
       
}
