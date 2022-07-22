// https://leetcode.com/problems/maximum-product-subarray/
public class MaxProdSubarray {

	public static void main(String[] args) {	
		int[] nums = {2,3,-2,4};
		int k = maxProduct2(nums);
		System.out.println(k);
	}
	
	public static int maxProduct(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		long[] product = new long[nums.length];
        int[]  DP= new int[nums.length];
        int max = nums[0];
        DP[0] = nums[0];
        product[0] = nums[0];
        int numNegatives = 0;
        int firstNegative = -1;
        if(nums[0] < 0) {
        	firstNegative = 0;
        	numNegatives++;
        }
        for(int i = 1; i < nums.length; i++) {
        	int num = nums[i];
        	if(product[i - 1] == 0) {
        		product[i] = num;
        	}else {
        		product[i] = product[i - 1] * num;
        	}
        	if(num < 0) {
        		numNegatives++;
        		if(firstNegative == -1) {
        			firstNegative = i;
        		}
        		if(numNegatives % 2 == 1) {
        			if(firstNegative != i) {
        				DP[i] = (int) (product[i] / product[firstNegative]);
        			}else {
        				DP[i] = (int) product[i];
        			}
        		}else {
        			DP[i] = (int) product[i];
        		}
        	}else if (num == 0) {
        		numNegatives = 0;
        		firstNegative = -1;
        	}else {
        		DP[i] = Math.max(DP[i - 1] * num, num);
        	}
        	max = Math.max(max, Math.max(num, DP[i]));
        	
        }
        return max;
    }
	public static int maxProduct2(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			int num = nums[i];
			int temp = Math.max(num, Math.max(max * num, min * num));
			min = Math.min(num, Math.min(min * num, max * num));
			max = temp;
			res = Math.max(res, max);
		}
		return res;
	}
}
