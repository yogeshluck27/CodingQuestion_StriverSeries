package Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
	// Input : intervals= [[1,2],[3,5],[6,7],[8,10],[12,16]] newInterval=[4,8]
	// output : [[1,2],[3,10],[12,16]]
	// Because [4,8] overlaps with [3,5] [6,7] [8,10]
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();

		for (int[] in : intervals) {
			if (in[1] < newInterval[0]) { // in[1,2] < newInterval [4,8]
				result.add(in);
			} else if (newInterval[1] < in[0]) { // newInterval [4,8] < in[12,16]
				result.add(newInterval);
				newInterval = in;
			} else if (in[1] > newInterval[0]) {
				// Overlapping intervals
				newInterval[0] = Integer.min(newInterval[0], in[0]);
				newInterval[1] = Integer.max(newInterval[1], in[1]);
			}
		}
		result.add(newInterval);
		return result.toArray(new int[result.size()][]);

	}
}
