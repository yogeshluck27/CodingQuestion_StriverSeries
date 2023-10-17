package GraphSeries;

import java.util.ArrayList;
import java.util.Stack;

//Apply DFS traversing on given graph
//At the same time push the item to stack whose DFS is done
//At the end pop the item from stack you will get topological order.

public class TopologicalSortDFS {

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		int vis[] = new int[V];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				dfs(i, vis, st, adj);
			}
		}
		int ans[] = new int[V];
		int i = 0;
		while (!st.isEmpty()) {
			ans[i++] = st.peek();
			st.pop();
		}
		return ans;
	}

	public static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {

		vis[node] = 1;
		for (int neighbor : adj.get(node)) {
			if (vis[neighbor] == 0) {
				dfs(neighbor, vis, st, adj);
			}
		}
		st.push(node); // before returning you need to push item to stack
	}
}
