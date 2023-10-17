package GraphSeries;
//Explanation: The idea behind SCC is that if we start from any node in a component, 

//we must be able to reach all other nodes in that component. 
//Note that by components here, we mean that we group certain nodes in the graph that meet the condition
//for every node in that component. The marked components in the following graph are from an SCC.

import java.util.ArrayList;
import java.util.Stack;

//Intuition: The idea behind KosaRaju�s algorithm is to do a DFS in a controlled fashion such that 
//we won�t be able to go from one SCC to other. One DFS call would visit all the nodes in an SCC only.

//Approach :

//Sort all the nodes according to their topo sort(loosely based topo sort as we may have cycles here)
//Transpose the graph i.e reverse all the edges of the graph
//Use the topo sort or the increasing order of finishing time to find the strongly connected components using DFS.
public class StronglyConnectedNodes {
	private void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int vis[]) {
		vis[node] = 1;
		for (Integer it : adj.get(node)) {
			if (vis[it] == 0) {
				dfs(it, st, adj, vis);
			}
		}

		st.push(node);
	}

	private void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int vis[]) {
		vis[node] = 1;
		System.out.print(node + " ");
		for (Integer it : transpose.get(node)) {
			if (vis[it] == 0) {
				revDfs(it, transpose, vis);
			}
		}
	}
	
	void kosaRaju(ArrayList<ArrayList<Integer>> adj, int n) {
		int vis[] = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				dfs(i, st, adj, vis);
			}
		}

		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++)
			transpose.add(new ArrayList<Integer>());

		for (int i = 0; i < n; i++) {
			vis[i] = 0;
			for (Integer it : adj.get(i)) {
				transpose.get(it).add(i);
			}
		}

		while (st.size() > 0) {
			int node = st.peek();
			st.pop();
			if (vis[node] == 0) {
				System.out.print("SCC: ");
				revDfs(node, transpose, vis);
				System.out.println();
			}
		}

	}

	public static void main(String args[]) {
		int n = 7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(3);
		adj.get(2).add(1);
		adj.get(3).add(2);
		adj.get(3).add(5);
		adj.get(4).add(6);
		adj.get(5).add(4);
		adj.get(6).add(5);

		StronglyConnectedNodes obj = new StronglyConnectedNodes();
		obj.kosaRaju(adj, n);

	}
}
