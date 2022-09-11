import java.util.*;
public class divideIntervals {
	static class group implements Comparable<group>{ 
		int start;
		int end;
		public group(int s, int e) {
			start = s;
			end = e;
		}
		@Override
		public int compareTo(group o) {
			// TODO Auto-generated method stub
			if(this.start > o.start) {
				return 1;
			}else if(this.start == o.start) {
				return this.end - this.end;
			}else {
				return -1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][]intervals = {{441459,446342},{801308,840640},{871890,963447},{228525,336985},{807945,946787}, {479815,507766}, {693292,944029}, {751962,821744}};
//		int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
		int res = minGroups(intervals);
		System.out.println(res);
	}
	
	public static int minGroups(int[][] intervals) {
		group[] groups = new group[intervals.length];
		for(int i = 0; i < intervals.length; i++) {
			groups[i] = new group(intervals[i][0], intervals[i][1]);
		}
		Arrays.sort(groups);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int count = 1;
		pq.add(groups[0].end);
		for(int i = 1; i < intervals.length; i++) {
			int minSoFar = pq.peek();
			// new group
			if(groups[i].start <= minSoFar) {
				count++;
				pq.add(groups[i].end);
			}else {
				pq.poll();
				pq.add(groups[i].end);
			}
		}
		return count;
    }
	
	
}
