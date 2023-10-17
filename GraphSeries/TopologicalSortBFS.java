package GraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//We have to create indegree array first using adj arrayList.
//How to create it?   take adj arrayList. suppose adj arrayList has 2 -> {3,4}
//we need to increase value of 3rd and 4th index of indegree array by 1. and repeat the same process for other index.
//Create queue
//First insert all nodes with indegree 0 in the queue.(You will have atleast one node whose indegree is 0).
//Then we need to iterate over the queue till its not empty
//Take element out from queue based on FIFO manner .add it in answer list
// Reduce indegree of adjacent nodes /neighbors of the element we have removed from queue &
//if indegree is 0 then add these neighbors  in queue
public class TopologicalSortBFS {

	static int[] toposort(int V, ArrayList<ArrayList<Integer>> adj) {
		
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
		int[] topo = new int[V];
		int i=0;
		while(!q.isEmpty()){
			int node = q.peek();
			q.remove(node);
			topo[i++]=node; 
			//Node is in your topo sort so please remove it from indegree
			for(int it : adj.get(node)){
				indegree[it]--;
				if(indegree[it] ==0){
					q.add(it);
				}
			}
		}
		return topo;
	}
}
