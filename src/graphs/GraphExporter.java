package graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import metrics.ClosenessCentrality;
import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class GraphExporter {
	
	//metoda koja exportuje graf u csv - koristi se samo za svrhe grafickog prikaza
	public static void exportGraph(UndirectedSparseGraph<Integer, String> graph, String fileName) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/data/" + fileName + ".csv")))) {
			for (String edge : graph.getEdges()) {
				Integer[] vertices = graph.getEndpoints(edge).toArray(new Integer[2]);
				pw.println(vertices[0] + "," + vertices[1]);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//metoda koje cuva podatke o metrikama za graf
	public static void saveMetrics(String fileName, double[] shell, double[] degrees, double[] betweenness,
			double[] closeness, double[] eigenvector) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/" + fileName + ".csv"))) {
			writer.write("ShellIndex,Degree,Betweenness,Closeness,Eigenvector\n");

			for (int i = 0; i < shell.length; i++) {
				writer.write(String.format("%.5f,%.5f,%.5f,%.5f,%.5f%n", shell[i], degrees[i], betweenness[i],
						closeness[i], eigenvector[i]));
			}


		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
