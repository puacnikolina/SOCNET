package decomposition;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;


import java.util.*;
import java.util.stream.Collectors;

public class BatageljZaversnik<V, E> {
    
	private UndirectedSparseGraph<V, E> graph;
	
	public BatageljZaversnik(UndirectedSparseGraph<V, E> graph) {
		super();
		if(graph == null) {
			throw new IllegalArgumentException("graph is null");
		}
		
		if(graph.getVertexCount() == 0) {
			throw new IllegalArgumentException("graph doesn't have any nodes");
		}
		
		this.graph = graph;
	}
	
	
	public Map<V, Integer> decomposition() {
        Map<V, Integer> vertexDegree = new HashMap<>();
        for (V vertex : graph.getVertices()) {
            vertexDegree.put(vertex, graph.degree(vertex));
        }
   
        PriorityQueue<V> queue = new PriorityQueue<>(Comparator.comparingInt(vertexDegree::get));
        queue.addAll(graph.getVertices());

        
        Map<V, Integer> shellIndex = new HashMap<>();
        int currentK = 0;
        
        while (!queue.isEmpty()) {
            V vertex = queue.poll(); 
            int degree = vertexDegree.get(vertex);

            currentK = Math.max(currentK, degree);
            shellIndex.put(vertex, currentK);
            
           
            for (V neighbor : graph.getNeighbors(vertex)) {
                if (!shellIndex.containsKey(neighbor)) {
                    int neighborDegree = vertexDegree.get(neighbor);
                    vertexDegree.put(neighbor, neighborDegree - 1);
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return shellIndex;
    }
    
	public UndirectedSparseGraph<V, E> kCore(int k) {
		Map<V, Integer> shellIndexes = decomposition();
		UndirectedSparseGraph<V, E> newGraph = new UndirectedSparseGraph<>();
		
		for(V vertex : graph.getVertices()) {
			newGraph.addVertex(vertex);
		}
		
		for(E edge : graph.getEdges()) {
			newGraph.addEdge(edge, graph.getIncidentVertices(edge));
		}
		
		
		shellIndexes = shellIndexes.entrySet().stream().filter(x -> x.getValue() < k)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		
		for(V vertex : shellIndexes.keySet()) {
			newGraph.removeVertex(vertex);
		}

		return newGraph;
	}
	
}
