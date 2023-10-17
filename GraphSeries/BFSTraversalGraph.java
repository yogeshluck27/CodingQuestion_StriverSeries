package GraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Add the staring node to the queue
//Poll the front of queue & add to the bfs list
//Search for its neighbours using adj list
//For every neighbour check if its visisted or not
//If yes leave it
//If no..Mark it as visited & add to bfs
//Do this process till queue is empty
public class BFSTraversalGraph {
	public ArrayList<Integer> bfsGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		boolean[] vis = new boolean[V+1];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(0);
		vis[0] = true;

		while (!queue.isEmpty()) {

			Integer node = queue.poll();
			bfs.add(node);

			for (int neighbour : adj.get(node)) {

				if (vis[neighbour] == false) {
					vis[neighbour] = true;
					queue.add(node);
				}
			}
		}
		return bfs;
	}
}
