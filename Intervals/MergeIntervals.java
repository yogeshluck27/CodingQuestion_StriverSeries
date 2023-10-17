package Intervals;
//First, we will group the closer intervals by sorting the given array of intervals(if it is not already sorted).

//After that, we will start traversing the array using a loop(say i) and insert the first element
//into our answer list(as the answer list is empty).
//Now, while traversing we will face two different cases
//Case 1: If the current interval can be merged with the last inserted interval of the answer list:
//In this case, we will update the end of the last inserted interval with the maximum(current interval’s end,
//last inserted interval’s end) and continue moving afterward. 
//Case 2: If the current interval cannot be merged with the last inserted interval of the answer list:
//In this case, we will insert the current interval in the answer array as it is. 
//And after this insertion, the last inserted interval of the answer list will obviously be updated to
//the current interval.
//Thus the answer list will be updated with the merged intervals and finally, we will return the answer list.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {

		List<int[]> res = new ArrayList<>();
		if (intervals.length == 0 || intervals == null) {
			return res.toArray(new int[0][]);
		}
		// First we need to sort the intervals array
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		// We need to take pair
		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int[] i : intervals) {
			// Need to check for merging condition
			if (i[0] < end) {
				end = Integer.max(end, i[1]);
			} else {
				res.add(new int[] { start, end });
				//Take new pair
				start = i[0]; 
				end = i[1];
			}
		}
		// Add end values of start & end
		res.add(new int[] { start, end });
		return res.toArray(new int[0][]);

	}
}
