package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import decomposition.BatageljZaversnik;
import decomposition.StraightForward;
import edu.uci.ics.jung.algorithms.cluster.WeakComponentClusterer;
import edu.uci.ics.jung.algorithms.metrics.Metrics;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import graphs.GraphExporter;
import graphs.GraphLoad;
import graphs.SmallGraphs;
import metrics.GraphMetrics;
import models.BarabasiAlbert;
import models.CorePeriphery;
import models.ErdosRenyi;

public class Tester {
	
	public static void main(String[] args) {
		
		//testiranje nad rucno pravljenim malim mrezama
//		UndirectedSparseGraph<Integer, String> graph = SmallGraphs.createTestGraph1();
//		BatageljZaversnik<Integer, String> bz = new BatageljZaversnik<>(graph);
//		Map<Integer, Integer> bzResults = bz.decomposition();
//		StraightForward<Integer, String> sf = new StraightForward<Integer, String>(graph);
//		Map<Integer, Integer> sfResults = sf.decomposition();
//		//ispis rezultata kako bi se poredilo
//		System.out.println("BZ: " + bzResults);
//		System.out.println("SF: " + sfResults);
//		compareAlgorithms(graph);
//		graphData(graph);
		
		//testiranje nad vestacki generisanim mrezama
		/*mreze su prvo generisane a onda sacuvane kako bi se uvek radilo sa istom mrezom*/
//		BarabasiAlbert barabasiGraph = new BarabasiAlbert(3000, 30, 0.01, 10);
//		ErdosRenyi erdosGraph = new ErdosRenyi(2500, 0.01);
//		CorePeriphery peripheryGraph = new CorePeriphery(3000, 0.9, 0.02, 0.01, 0.05);
//		GraphExporter ex = new GraphExporter();
//		ex.exportGraph(barabasiGraph.getGraph(), "BarabasiAlbertGraph");
//		ex.exportGraph(erdosGraph.getGraph(), "ErdosRenyiGraph");
//		ex.exportGraph(peripheryGraph.getGraph(), "CorePeripheryGraph");
		
		
		//ucitavanje generisanih mreza i izvrsavanje testova nad njima
		
		//Erdos-Renyi mreza
//		UndirectedSparseGraph<Integer, String> erdosGraph = GraphLoad.loadGeneratedGraph("src/data/ErdosRenyiGraph.csv");
//		GraphMetrics.calculateMetrics(erdosGraph);
//		double[] smd = GraphMetrics.smallWorldCoefWithDiameter(erdosGraph);
//		System.out.println("small world coefficient: " + smd[0]);
//		System.out.println("diameter: " + smd[1]);		
//		compareAlgorithms(erdosGraph);
//		graphData(erdosGraph);
		
		//Barabasi-Albert mreza
//		UndirectedSparseGraph<Integer, String> barabasiGraph = GraphLoad.loadGeneratedGraph("src/data/BarabasiAlbertGraph.csv");
//		GraphMetrics.calculateMetrics(barabasiGraph);
//		double[] smd = GraphMetrics.smallWorldCoefWithDiameter(barabasiGraph);
//		System.out.println("small world coefficient: " + smd[0]);
//		System.out.println("diameter: " + smd[1]);
//		compareAlgorithms(barabasiGraph);
//		graphData(barabasiGraph);
		
		//Core-Periphery
//		UndirectedSparseGraph<Integer, String> peripheryGraph = GraphLoad.loadGeneratedGraph("src/data/CorePeripheryGraph.csv");
//		GraphMetrics.calculateMetrics(peripheryGraph);
//		double[] smd = GraphMetrics.smallWorldCoefWithDiameter(peripheryGraph);
//		System.out.println("small world coefficient: " + smd[0]);
//		System.out.println("diameter: " + smd[1]);
//		compareAlgorithms(peripheryGraph);
//		graphData(peripheryGraph);
		
		
		
		//testiranje nad realnim mrezama
		
		//CA-CondMat mreza
//		long time = System.currentTimeMillis();
//		UndirectedSparseGraph<Integer, String> condGraph = GraphLoad.loadRealGraph("src/data/CA-CondMat.txt");
//		System.out.println("generated in: " + (System.currentTimeMillis() - time)/1000.0);
//		graphData(condGraph);
//		double[] results = GraphMetrics.smallWorldCoefWithDiameter(condGraph);
//		System.out.printf("small world coefficient: ", results[0]);
//		System.out.printf("diameter: ", results[1]);
//		GraphMetrics.calculateMetrics(condGraph);
//		System.out.println("done in: " + (System.currentTimeMillis() - time)/1000.0);
//		compareAlgorithms(condGraph);
		
		//Email-Enron mreza
//		long time = System.currentTimeMillis();
//		UndirectedSparseGraph<Integer, String> emailGraph = GraphLoad.loadRealGraph("src/data/Email-Enron.txt");
//		System.out.println("generated in: " + (System.currentTimeMillis() - time)/1000.0);
//		graphData(emailGraph);
//		double[] results = GraphMetrics.smallWorldCoefWithDiameter(emailGraph);
//		System.out.printf("small world coefficient:", results[0]);
//		System.out.printf("diameter: ", results[1]);
//		GraphMetrics.calculateMetrics(emailGraph);
//		System.out.println("done in: " + (System.currentTimeMillis() - time)/1000.0);
//		compareAlgorithms(emailGraph);

		//CA-HepPh mreza
//		long time = System.currentTimeMillis();
//		UndirectedSparseGraph<Integer, String> hepphGraph = GraphLoad.loadRealGraph("src/data/CA-HepPh.txt");
//		System.out.println("generated in: " + (System.currentTimeMillis() - time)/1000.0);
//		graphData(hepphGraph);
//		double[] results = GraphMetrics.smallWorldCoefWithDiameter(hepphGraph);
//		System.out.printf("small world coefficient: ", results[0]);
//		System.out.printf("diameter: ", results[1]);
//		GraphMetrics.calculateMetrics(hepphGraph);
//		System.out.println("done in: " + (System.currentTimeMillis() - time)/1000.0);
	
	}
	
	/*metoda za poredjenje rezultata algoritama*/
	private static void compareAlgorithms(UndirectedSparseGraph<Integer, String> graph) {
		BatageljZaversnik<Integer, String> bz = new BatageljZaversnik<>(graph);
		Map<Integer, Integer> bzResults = bz.decomposition();
		StraightForward<Integer, String> sf = new StraightForward<Integer, String>(graph);
		Map<Integer, Integer> sfResults = sf.decomposition();
		
		boolean isSame = true;

        for (Integer vertex : graph.getVertices()) {
            Integer bzIndex = bzResults.get(vertex);
            Integer sfIndex = sfResults.get(vertex);

            if (!bzIndex.equals(sfIndex)) {
                System.out.printf("difference for vertex %d: BZ = %d, SF = %d%n", vertex, bzIndex, sfIndex);
                isSame = false;
            }
        }

        if (isSame) {
            System.out.println("the results for both algorithms are identical");
        }
	}
	
	/*metoda koja prikazuje neke osnovne podatke o grafu*/
	private static void graphData(UndirectedSparseGraph<Integer, String> graph) {
		int vertexNumber = graph.getVertexCount();
		System.out.println("vertex number: " + vertexNumber);
		
		int edgeNumber = graph.getEdgeCount();
		System.out.println("edge number: " + edgeNumber);
		
		double graphDensity = (double) edgeNumber / (vertexNumber * (vertexNumber - 1) / 2);
		System.out.println("graph density: " + graphDensity);
		
		Map<Integer, Integer> degrees = getDegrees(graph);
		int minDegree = Collections.min(degrees.values());
	    int maxDegree = Collections.max(degrees.values());
	    System.out.println("minimum degree: " + minDegree);
	    System.out.println("maximum degree: " + maxDegree);
	    
	    WeakComponentClusterer<Integer, String> clusterer = new WeakComponentClusterer<>();
	    int numberOfComponents = clusterer.transform(graph).size();
	    System.out.println("num of components: " + numberOfComponents);
	    
	    Map<Integer, Double> clusteringCoef = Metrics.clusteringCoefficients(graph);
		double clustCoef = 0;
		for(Integer vert : clusteringCoef.keySet()) {
			clustCoef += clusteringCoef.get(vert);
		}
		clustCoef /= (double) clusteringCoef.keySet().size();
		System.out.println("clustering coefficient: " + clustCoef);
	    
	}
	
	private static Map<Integer, Integer> getDegrees(UndirectedSparseGraph<Integer, String> graph){
		Map<Integer, Integer> degrees = new HashMap<>();
	    for (Integer vertex : graph.getVertices()) {
	        degrees.put(vertex, graph.degree(vertex));
	    }
	    return degrees;
	}
	
	
}
