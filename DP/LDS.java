import java.util.*;
public class LDS {

	public static void main(String[] args) {
		int[] arr = {4,8,10,240};
		List<Integer> res = largestDivisibleSubset(arr);
		for(int e: res) {
			System.out.println(e + " ");
		}

	}
	
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		int[] DP = new int[n];
		List<Integer> ls = new ArrayList<Integer>();
		if(n == 0) {
			return ls;
		}else {
			int maxSubsize = -1;
			int maxSubIdx = -1;
			for(int i = 0; i < n; i++) {
				int subSize = 0;
				for(int j = 0; j < i; j++) {
					if(nums[i] % nums[j] == 0 && subSize < DP[j]) {
						subSize = DP[j];
					}
				}
				DP[i] = subSize + 1;
				if (maxSubsize < DP[i]) {
					maxSubsize = DP[i];
					maxSubIdx = i;
			    }
			}
			// building the list here requires you to track the last element. 
			int cur = maxSubsize;
			int curTail = nums[maxSubIdx];
			for(int i = maxSubIdx; i >=0; i--) {
				if(cur == 0) {
					break;
				}
				if(curTail % nums[i] == 0 && cur == DP[i]) {
					ls.add(0, nums[i]);
					curTail = nums[i];
					cur--;
				}
			}
			return ls;
			
		}
		
		
    }
	

}
