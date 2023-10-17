package GraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Input: numCourses = 2, prerequisites = [[1,0]]
//V =2
//We need to form adj List of List //Fisrt add arrayList to every poistio of adj list
//[1,0] => adj [ [] , [0] , [] ]
public class CourseSchedule_1 {
    public boolean isPossible(int V, int[][] prerequisites) {
    		
    	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    	
    	for(int i=0;i<V; i++){
    		adj.add(new ArrayList<>());
    	}
    	
    	for(int i=0 ; i < prerequisites.length ;i++){
    		adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
    	}
    	

		
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
		int cnt =0;
		while(!q.isEmpty()){
			int node = q.peek();
			q.remove(node);
			cnt++;
			for(int it : adj.get(node)){
				indegree[it]--;
				if(indegree[it] ==0){
					q.add(it);
				}
			}
		}
		if (cnt == V) return true;
		else return false;
    	
    }
}
