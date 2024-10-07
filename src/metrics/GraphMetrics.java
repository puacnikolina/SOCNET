package metrics;

import java.util.Map;

import org.apache.commons.math4.legacy.stat.correlation.SpearmansCorrelation;

import decomposition.BatageljZaversnik;
import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.algorithms.shortestpath.UnweightedShortestPath;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import graphs.GraphExporter;

public class GraphMetrics {
	
	public static void calculateMetrics(UndirectedSparseGraph<Integer, String> graph) {
		
        BetweennessCentrality<Integer, String> betweennessCentrality = new BetweennessCentrality<>(graph);
        System.out.println("betweenness centrality done");
        ClosenessCentrality closenessCentrality = new ClosenessCentrality(graph);
        System.out.println("closeness centrality done");
        EigenvectorCentrality<Integer, String> eigenvectorCentrality = new EigenvectorCentrality<>(graph);
        eigenvectorCentrality.acceptDisconnectedGraph(true);
        eigenvectorCentrality.evaluate();
        System.out.println("eigenvector centrality done");
        BatageljZaversnik<Integer, String> bz = new BatageljZaversnik<>(graph);
		Map<Integer, Integer> shellIndecies = bz.decomposition();
        

		double[] spaermanCorrelations = calculateSpearmanCorrelations(graph, shellIndecies, betweennessCentrality,
		        closenessCentrality, eigenvectorCentrality);
		double spearmanShellDegree = spaermanCorrelations[0];
		double spearmanShellBetweenness = spaermanCorrelations[1];
		double spearmanShellCloseness = spaermanCorrelations[2];
		double spearmanShellEigenvector = spaermanCorrelations[3];
		
		System.out.println("shell - degree correlation: " + spearmanShellDegree);
	    System.out.println("shell - betweenness correlation: " + spearmanShellBetweenness);
	    System.out.println("shell - closeness correlation: " + spearmanShellCloseness);
	    System.out.println("shell - eigenvector correlation: " + spearmanShellEigenvector);
		
	}

	private static double[] calculateSpearmanCorrelations(UndirectedSparseGraph<Integer, String> graph,
			Map<Integer, Integer> shellIndices, BetweennessCentrality<Integer, String> betweennessCentrality,
			ClosenessCentrality closenessCentrality, EigenvectorCentrality<Integer, String> eigenvectorCentrality) {
		
		double[] res = new double[4];
		
		int size = graph.getVertexCount(); 
        double[] shell = new double[size]; 
        double[] degs = new double[size];  
        double[] betw = new double[size];  
        double[] clos = new double[size];  
        double[] eige = new double[size]; 
		
        int index = 0;
        for (Integer v : graph.getVertices()) {
            shell[index] = shellIndices.get(v);
            degs[index] = graph.degree(v);
            betw[index] = betweennessCentrality.getVertexScore(v);
            clos[index] = closenessCentrality.getClosenessMap().get(v);
            eige[index] = eigenvectorCentrality.getVertexScore(v);
            index++;
        }
        
        //pozvano je samo nakon prvog pokretanja kako bi se sacuvali podaci - ne mora vise da se poziva
        //GraphExporter.saveMetrics("CorePeripheryCorrelations", shell, degs, betw, clos, eige);
        
        
        SpearmansCorrelation sc = new SpearmansCorrelation();
        res[0] = sc.correlation(shell, degs);
        res[1] = sc.correlation(shell, betw);
        res[2] = sc.correlation(shell, clos);
        res[3] = sc.correlation(shell, eige);

		return res;
	}
	
	
	public static double[] smallWorldCoefWithDiameter(UndirectedSparseGraph<Integer, String> graph) {
		double sum = 0;
		double diametar = 0;
		for(Integer current : graph.getVertices()) {
			double[] arr = calculateDistanceAndDiameter(graph, current);
			if(arr[1] > diametar) {
				diametar = arr[1];
			}
			sum += arr[0];
		}
		double vertSq = graph.getVertexCount() * (graph.getVertexCount() - 1);
		double coef = sum / vertSq;
		return new double[]{coef, diametar};
    }

    private static double[] calculateDistanceAndDiameter(UndirectedSparseGraph<Integer, String> graph, Integer vertex) {
        UnweightedShortestPath<Integer, String> uwsp = new UnweightedShortestPath<>(graph);
        Map<Integer, Number> distanceMap = uwsp.getDistanceMap(vertex);
        double diameter = distanceMap.values().stream().mapToDouble(Number::doubleValue).max().orElse(-1.0);
        double distance = 0.0;
        for (Number value : distanceMap.values()) {
            distance += value.doubleValue();
        }
        return new double[]{distance, diameter};
    }

}
