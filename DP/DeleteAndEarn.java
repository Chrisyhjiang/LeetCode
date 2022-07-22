import java.util.*;

public class DeleteAndEarn {

	public static void main(String[] args) {
		int[] nums = {3,5};
		int k = deleteAndEarn2(nums);
		System.out.print(k);
	}
	public static int deleteAndEarn(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int e: nums) {
			if(hm.containsKey(e)) {
				hm.put(e, hm.get(e) + 1);
			}else {
				hm.put(e, 1);
			}
		}
		
		if(hm.size() == 1) {
			return nums[0] * hm.get(nums[0]);
		}
		
		int[] DP = new int[hm.size()];
		int index = 0;
		int prev = -1;
		for(int k: hm.keySet()) {
			if(index == 0) {
				DP[0] = k * hm.get(k);
			}else {
				DP[index] = k * hm.get(k);
				if(k - prev != 1) {
					if(index > 1) {
						DP[index] += Math.max(DP[index - 1], DP[index - 2]);
					}else {
						DP[index] += DP[index-1];
					}
				}else {
					if(index > 2) {
						DP[index] += Math.max(DP[index - 2], DP[index-3]);
					}else if (index > 1) {
						DP[index] += DP[index - 2];
					}
				}
			}
			prev = k;
			index++;
			
		}
		return Math.max(DP[DP.length - 1], DP[DP.length - 2]);
    }
	public static int deleteAndEarn2(int[] nums) {
		// indicies is the index of the cache;
		Arrays.sort(nums);
		int[] cache = new int[10003];
		int len = 0;
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int e: nums) {
			if(cache[e] == 0) {
				indices.add(e);
				len++;
			}
			cache[e]++;
		}
		if(len == 1) {
			return nums[0] * cache[nums[0]];
		}else {
			int[] DP = new int[len];
			int count = 0;
			while(count < DP.length) {
				int number = indices.get(count);
				int freq = cache[number];
				DP[count] = number * freq;
				if(count > 0) {
					if(indices.get(count) - indices.get(count - 1) > 1) {
						if(count > 1) {
							DP[count] += Math.max(DP[count - 1], DP[count - 2]);
						}else {
							DP[count] += DP[count-1];
						}
					}else {
						if(count > 2) {
							DP[count] += Math.max(DP[count - 2], DP[count-3]);
						}else if (count > 1) {
							DP[count] += DP[count - 2];
						}
					}
				}
				count++;
			}
			return Math.max(DP[DP.length - 1], DP[DP.length - 2]);
		}
		
	}

}
