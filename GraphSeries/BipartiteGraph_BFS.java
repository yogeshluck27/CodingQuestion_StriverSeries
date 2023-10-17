package GraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//Bipartite graph is a graph where no two adjacent nodes have same color
//Acyclic Graph & Cyclic Graph with even no of nodes in cycle can be a Bipartite graph
//Cyclic Graph with odd no of nodes in cycle is not bipartite graph
//Algorithm :

// We will have queue & color array & adj array list will be given
// We need to take first element from graph .add it to queue.mark corresponding element in color array with value 0
// Peek & remove the item from queue .check for the adj nodes. and mark corresponding elements in color array
//with opposite color
//At any point if two adj elements in color array has same color then the graph is not bipartite
//Repeat the steps till queue is not empty
public class BipartiteGraph_BFS {
	//If graph is having more than one component then below method is required
	//Which will apply check method on every node of graph if its not colored
	public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] color = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = -1;
		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (check(i, V, adj, color) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean check(int start, int v, ArrayList<ArrayList<Integer>> adj, int[] color) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		color[start] = 0;

		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			// If the adjacent node is yet not colored , you will give opposite
			// color of the node
			for (int it : adj.get(node)) {

				if (color[it] == -1) {
					color[it] = 1 - color[node];
					q.add(it);
				}
				// is the adjacent guy having the same color
				// someone did color it on same other path
				else if (color[it] == color[node]) {
					return false;
				}
			}
		}
		return true;
	}
}
