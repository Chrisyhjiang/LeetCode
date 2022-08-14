import java.util.*;
public class highEdge {

	public static void main(String[] args) {
		int[] arr = {3,3,3,0};
		int res = edgeScore(arr);
		System.out.println(res);
	}
	
	public static int edgeScore(int[] edges) {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0; i < edges.length; i++) {
			if(hm.containsKey(edges[i])) {
				int val = hm.get(edges[i]) + i;
				if(val > max) {
					maxIndex = edges[i];
					max = val;
				}else if (i == max) {
					maxIndex = Math.min(maxIndex, edges[i]);
				}
				hm.replace(edges[i], val);
			}else {
				if(i > max) {
					maxIndex = edges[i];
					max = i;
				}else if (i == max) {
					maxIndex = Math.min(maxIndex, edges[i]);
				}
				hm.put(edges[i], i);
			}
		}
		return maxIndex;
    }
	public static int edgeScore2(int[] edges) {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		int[] nums = new int[100001];
		for(int i = 0; i < edges.length; i++) {
			nums[edges[i]] += i;
			if(nums[edges[i]] > max) {
				maxIndex = edges[i];
				max = nums[edges[i]];
			}else if(nums[edges[i]] == max) {
				maxIndex = Math.min(maxIndex, edges[i]);
			}
		}
		return maxIndex;
	}
}
