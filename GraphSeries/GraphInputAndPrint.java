package GraphSeries;

import java.util.ArrayList;

public class GraphInputAndPrint {

	public static void main(String[] args) {
		int n = 3, m = 3;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		// n+1
		// Add empty arraylist to all positions of main List
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		// edge 1--2
		// Undirected Graph
		adj.get(1).add(2);
		adj.get(2).add(1);

		// edge 2-->3
		// directed Graph
		adj.get(2).add(3);
		//adj.get(3).add(2);

		// edge 1--3
		// Undirected Graph
		adj.get(1).add(3);
		adj.get(3).add(1);

		// Print all the edges
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j));
			}
			System.out.println();

		}
	}
}
