package GraphSeries;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {
	//First we have given 2D matrix of char 0 & 1.
	//We need to check how many connected 1's are there which forms island 
	//And how many such islands are there in the given matrix of 2-d
	//So we have to start from one point and call traverse using bfs or dfs 
	//We will also keep visited 2D array.Once we visit any node we will mark it as visited in bfs method
	//And here in below method starting point is the one which is not visited & which has value '1'
	//3 starting nodes = 3 islands
	
	public int numIslands(char[][] grid) {
		int cnt = 0;
		int n = grid.length; // row
		int m = grid[0].length; // column
		int[][] vis = new int[n][m];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (vis[row][col] == 0 && grid[row][col] == '1') {
					cnt++;
					bfs(row, col, vis, grid);
				}
			}
		}
		return cnt;
	}
	//Here we have to start at given row & col
	//We have to for visited node array - 2D array
	//We should have a queue which stores the node (pair).
	//Once we start at given row,col pair .mark corresponding visited array =1
	//Add that node/pair in queue
	//While queue is not empty we have to follow below process
	//take the latest pair from queue
	//Search for its neighbors & add those in queue 
	// Here we have to check in 8 directions for the neighbors
	
	//Valid neighbor is the one whose value is 1 & its not visited yet & its in the n*m 2-d matrix (checking boundary)
	//as soon as we get the valid pair , we will add it in queue  mark it as visited in Visited 2-D array.
	
	public void bfs(int ro, int co, int[][] vis, char[][] grid) {

		vis[ro][co] = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(ro, co));
		int n = grid.length;
		int m = grid[0].length;

		while (!q.isEmpty()) {
			int row = q.peek().first;
			int col = q.peek().second;
			q.remove();

			// Traverse neighbors in all 8 directions and mark them if its land
			for (int delrow = -1; delrow <= 1; delrow++) {
				for (int delcol = -1; delcol <= 1; delcol++) {
					int nrow = row + delrow;
					int ncol = col + delcol;

					if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
							&& grid[nrow][ncol] == '1') {
							vis[nrow][ncol]=1;
							q.add(new Pair(nrow,ncol));
					}
				}
			}
		}

	}

}

class Pair {
	int first;
	int second;

	public Pair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

}
