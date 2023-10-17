package GraphSeries;

import java.util.ArrayList;

public class DFSTraversalGraph {

	public static void dfs(int node ,boolean vis[],ArrayList<ArrayList<Integer>> adj ,ArrayList<Integer> ls){
		
		//Making current node as visited
		
		vis[node] = true;
		ls.add(node);
		
		//Getting neighbour nodes & call dfs method recursvively
		for(int neighbour : adj.get(node)){
			if(vis[neighbour] == false){
				dfs(neighbour , vis,adj,ls);
			}
		}
	}
	
	public ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
		
		boolean[] vis = new boolean[V+1];
		vis[0] = true; //start with node 0//You can start with any node
		ArrayList<Integer> ls = new ArrayList<Integer>();
		dfs(0,vis,adj,ls);
		
		return ls;
	}
}
