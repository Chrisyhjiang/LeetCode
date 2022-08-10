import java.util.*;
// https://leetcode.com/problems/merge-intervals/submissions/
public class MergeInterval{

	public static void main(String[] args) {
		int[][] intervals = {{1,4},{4,5}};
		int[][] res = merge(intervals);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}
	
	public static int[][] merge(int[][] intervals) {
		// sort the array based on the first element then everything is increasing. 
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> firstLine = new ArrayList<Integer>();
		firstLine.add(intervals[0][0]);
		firstLine.add(intervals[0][1]);
		ls.add(firstLine);
		for(int i = 1; i < intervals.length; i++) {
			// as the intervals are increasing, we can convert. 
			int start = intervals[i][0];
			int end = intervals[i][1];
			if(start > ls.get(ls.size() - 1).get(1)) {
				ArrayList<Integer> line = new ArrayList<Integer>();
				line.add(start);
				line.add(end);
				ls.add(line);
			}else{
				ArrayList <Integer>line = ls.get(ls.size() - 1);
				line.set(1, Math.max(end, line.get(1)));
				ls.set(ls.size() - 1, line);
			}
		}
		int[][] res = new int[ls.size()][2];
		for(int i = 0; i < res.length; i++) {
			res[i][0] = ls.get(i).get(0);
			res[i][1] = ls.get(i).get(1);
		}
		return res;
    }

	
}
