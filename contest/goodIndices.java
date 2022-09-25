import java.util.*;
public class goodIndices {

	public static void main(String[] args) {
		System.out.println(1 & 2 & 3);

	}
	
	public List<Integer> goodIndices(int[] nums, int k) {
		int n = nums.length;
		int[] nonIncrease = new int[n];
		int[] nonDecrease = new int[n];
        List<Integer> res = new LinkedList<Integer>();
        nonIncrease[0] = 1;
        nonDecrease[n-1] = 1;
        
        for(int i = 1; i < n; i++) {
        	if(nums[i] <= nums[i-1]) {
        		nonIncrease[i] = nonIncrease[i-1] + 1;
        	}else {
        		nonIncrease[i] = 1;
        	}
        }
        for(int i = n-2; i >= 0; i--) {
        	if(nums[i] <= nums[i+1]) {
        		nonIncrease[i] = nonIncrease[i+1] + 1;
        	}else {
        		nonIncrease[i] = 1;
        	}
        }
        
        
        for(int i = k; i < n - k; i++) {
        	if(nonIncrease[i-1] > k && nonDecrease[i+1] > k) {
        		res.add(i);
        	}
        }
        
        return res;
	}
}
