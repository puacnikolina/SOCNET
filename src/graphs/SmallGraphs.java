package graphs;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;


public class SmallGraphs {
	
	public static UndirectedSparseGraph<Integer, String> createTestGraph1() {
		UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();

   	 
        for (int i = 0; i <= 15; i++) {
            graph.addVertex(i);
        }
        
        graph.addEdge("Edge-0", 0, 2);
        graph.addEdge("Edge-1", 0, 1);
        graph.addEdge("Edge-2", 0, 10);
        graph.addEdge("Edge-3", 1, 2);
        graph.addEdge("Edge-4", 1, 10);
        graph.addEdge("Edge-5", 1, 4);
        graph.addEdge("Edge-6", 2, 10);
        graph.addEdge("Edge-7", 2, 12);
        graph.addEdge("Edge-8", 2, 14);
        graph.addEdge("Edge-9", 2, 15);
        graph.addEdge("Edge-10", 3, 4);
        graph.addEdge("Edge-11", 3, 7);
        graph.addEdge("Edge-12", 3, 13);
        graph.addEdge("Edge-13", 4, 6);
        graph.addEdge("Edge-14", 5, 6);
        graph.addEdge("Edge-15", 6, 8);
        graph.addEdge("Edge-16", 7, 13);
        graph.addEdge("Edge-17", 10, 11);
        graph.addEdge("Edge-18", 12, 14);
        graph.addEdge("Edge-19", 13, 14);
  
        return graph;
   }
   
   
	public static UndirectedSparseGraph<Integer, String> createTestGraph2() {
		UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
       
	       
	  	for (int i = 0; i <= 16; i++) {
	        graph.addVertex(i);
	    }
	    
	    graph.addEdge("Edge-0", 0, 14);
	    graph.addEdge("Edge-1", 0, 13);
	    graph.addEdge("Edge-2", 0, 12);
	    graph.addEdge("Edge-3", 0, 2);
	    graph.addEdge("Edge-4", 0, 4);
	    graph.addEdge("Edge-5", 1, 4);
	    graph.addEdge("Edge-6", 1, 5);
	    graph.addEdge("Edge-7", 2, 11);
	    graph.addEdge("Edge-8", 2, 12);
	    graph.addEdge("Edge-9", 2, 3);
	    graph.addEdge("Edge-10", 2, 4);
	    graph.addEdge("Edge-11", 4, 5);
	    graph.addEdge("Edge-12", 4, 8);
	    graph.addEdge("Edge-13", 5, 10);
	    graph.addEdge("Edge-14", 6, 7);
	    graph.addEdge("Edge-15", 6, 8);
	    graph.addEdge("Edge-16", 6, 9);
	    graph.addEdge("Edge-17", 7, 9);
	    graph.addEdge("Edge-18", 8, 9);
	    graph.addEdge("Edge-19", 11, 12);
	    graph.addEdge("Edge-20", 11, 13);
	    graph.addEdge("Edge-21", 12, 13);
	    graph.addEdge("Edge-22", 14, 15);
	    graph.addEdge("Edge-23", 15, 16);
	    
	    
	    
	    return graph;
  }
   
	public static UndirectedSparseGraph<Integer, String> createTestGraph3() {
		UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
          
          
          for (int i = 0; i <= 15; i++) {
              graph.addVertex(i);
          }
         
          graph.addEdge("Edge-0", 0, 1);
          graph.addEdge("Edge-1", 0, 7);
          graph.addEdge("Edge-2", 0, 2);
          graph.addEdge("Edge-3", 0, 4);
          graph.addEdge("Edge-4", 0, 5);
          graph.addEdge("Edge-5", 0, 12);
          graph.addEdge("Edge-6", 0, 14);
          graph.addEdge("Edge-7", 0, 15);
          graph.addEdge("Edge-8", 0, 9);
          graph.addEdge("Edge-9", 0, 8);
          graph.addEdge("Edge-10", 0, 11);
          graph.addEdge("Edge-11", 0, 10);
          graph.addEdge("Edge-12", 1, 4);
          graph.addEdge("Edge-13", 1, 5);
          graph.addEdge("Edge-14", 1, 6);
          graph.addEdge("Edge-15", 1, 3);
          graph.addEdge("Edge-16", 1, 2);
          graph.addEdge("Edge-17", 1, 7);
          graph.addEdge("Edge-18", 2, 6);
          graph.addEdge("Edge-19", 2, 3);
          graph.addEdge("Edge-20", 2, 5);
          graph.addEdge("Edge-21", 2, 4);
          graph.addEdge("Edge-22", 3, 4);
          graph.addEdge("Edge-23", 3, 6);
          graph.addEdge("Edge-24", 3, 5);
          graph.addEdge("Edge-25", 4, 5);
          graph.addEdge("Edge-26", 4, 6);
          graph.addEdge("Edge-27", 5, 6);
          graph.addEdge("Edge-28", 5, 12);
          graph.addEdge("Edge-29", 8, 10);
          graph.addEdge("Edge-30", 8, 9);
          graph.addEdge("Edge-31", 8, 11);
          graph.addEdge("Edge-32", 9, 11);
          graph.addEdge("Edge-33", 10, 11);
          graph.addEdge("Edge-34", 12, 13);
          graph.addEdge("Edge-35", 12, 15);
          graph.addEdge("Edge-36", 12, 14);
          graph.addEdge("Edge-37", 13, 14);
          graph.addEdge("Edge-38", 13, 15);
          graph.addEdge("Edge-39", 14, 15);
          
    
          return graph;
     }
   
	
}	
