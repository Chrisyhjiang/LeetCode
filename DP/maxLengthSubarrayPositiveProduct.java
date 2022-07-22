// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
import java.util.*;
public class maxLengthSubarrayPositiveProduct {
	
	public static void main(String[] args) {
		int[] nums = {-26,-34,2,26,-36,-28,18,0,34,0,21,-36,0,-33,27,24,30,0};
		int l = getMaxLen(nums);
		System.out.println(l);
	}
	public static int getMaxLen(int[] nums) {
       int numNegatives = 0;
       int firstNegative = -1;
       int lastNegative = -1;
       ArrayList<Integer> zeros = new ArrayList<Integer>();
       
       for(int i = 0; i < nums.length; i++) {
    	   int num = nums[i];
    	   if(num < 0) {
    		   numNegatives++;
    		   if(firstNegative == -1) {
    			   firstNegative = i;
    		   }
    		   lastNegative = i;
    	   }else if (num == 0) {
    		   zeros.add(i);
    	   }
       }
       if(zeros.isEmpty()) {
    	   if(numNegatives % 2 == 0) {
    		   return nums.length;
    	   }else {
    		   return nums.length - Math.min(firstNegative + 1, nums.length - lastNegative);
    	   }
       }else {
    	   int res = 0;
    	   if(zeros.size() == 1) {
    		   int l1 = maxLength(0, zeros.get(0) - 1, nums);
    		   int l2 = maxLength(zeros.get(0) + 1, nums.length - 1, nums);
    		   res = Math.max(l1,l2);
    	   }else {
    		   res = Math.max(res, maxLength(0, zeros.get(0) - 1, nums));
    		   for(int i = 0; i < zeros.size() - 1; i++) {
    			   res = Math.max(res, maxLength(zeros.get(i) + 1, zeros.get(i + 1) - 1, nums));
        	   }
    		   res = Math.max(res, maxLength(zeros.get(zeros.size() - 1) + 1, nums.length - 1, nums));
    	   }
    	   return res;
       }
       
    }

	public static boolean isPos(int start, int end, int[] nums) {
		int negatives = 0;
		for(int i = start + 1; i < end; i++) {
			if(nums[i] < 0) {
				negatives++;
			}
		}
		return (negatives % 2 == 0);
	}
	
	public static int maxLength(int start, int end, int[] nums) {
		int numNegatives = 0;
		int first = -1;
		int last = -1;
		for(int i = start; i <= end; i++) {
			int num = nums[i];
			if(num < 0) {
				numNegatives ++;
	    	   if(first == -1) {
	   			   first = i;
	   		   }
	   		   last = i;
	   	   }
		}
		if(numNegatives % 2 == 0) {
			return end - start + 1;
		}else {
			return Math.max(end - first, last - start); 
		}
	}
		
}
