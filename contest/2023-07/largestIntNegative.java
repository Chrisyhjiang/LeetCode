import java.util.*;
public class largestIntNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMaxK(int[] nums) {
		Arrays.sort(nums);
		HashSet<Integer> hs= new HashSet<Integer>();
		int res = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				if(hs.contains(- 1 * nums[i])) {
					res = Math.max(res, nums[i]);
				}
			}else {
				hs.add(nums[i]);
			}
		}
		return res;
    }

}
