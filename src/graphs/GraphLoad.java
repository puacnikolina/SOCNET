package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class GraphLoad {

	//za ucitavanje realnih mreza
	public static UndirectedSparseGraph<Integer, String> loadRealGraph(String fileName) {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                
                if (line.startsWith("#")) {
                    continue;
                }
                
                String[] tokens = line.split("\\s+");
                
                if (tokens.length < 2) {
                    continue; 
                }
                
                Integer fromNode = Integer.parseInt(tokens[0].trim());
                Integer toNode = Integer.parseInt(tokens[1].trim());
                
               
                graph.addVertex(fromNode);
                graph.addVertex(toNode);
                
               
                graph.addEdge(fromNode + "-" + toNode, fromNode, toNode, EdgeType.UNDIRECTED);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return graph;
    }
   
	//za ucitavanje vestacki generisanih mreza
	public static UndirectedSparseGraph<Integer, String> loadGeneratedGraph(String filePath) {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        int edgeCounter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
               
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    int vertex1 = Integer.parseInt(parts[0].trim());
                    int vertex2 = Integer.parseInt(parts[1].trim());

                    
                    graph.addVertex(vertex1);
                    graph.addVertex(vertex2);

                   
                    graph.addEdge("Edge-" + edgeCounter++, vertex1, vertex2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }	
	
}
