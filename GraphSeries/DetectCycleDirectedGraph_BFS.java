package GraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph_BFS {
	//We will use TopoLogical Sort BFS alogo
	//Topological sort can be applied only on DAG (Directed Acyclic Graph)
	//We will apply the alogo on the graph& if no of elements in topological sort list is equals to
	//No of elements in graph then no cycle else there is a cycle

	static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		
		int[] indegree = new int[V];
		//Form indegree array
		for(int i=0;i<V;i++){
			for(int it : adj.get(i)){
				indegree[it]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		//Add the elements in queue whose indegree is zero
		for(int i=0;i<V;i++){
			if(indegree[i]==0){
				q.add(i);
			}
		}
		//int[] topo = new int[V];
		int cnt =0;
		int i=0;
		while(!q.isEmpty()){
			int node = q.peek();
			q.remove(node);
			//topo[i++]=node; 
			cnt++;
			//Node is in your topo sort so please remove it from indegree
			for(int it : adj.get(node)){
				indegree[it]--;
				if(indegree[it] ==0){
					q.add(it);
				}
			}
		}
		///return topo;
		if (cnt == V) return false;
		else return true;
	}

	
}
