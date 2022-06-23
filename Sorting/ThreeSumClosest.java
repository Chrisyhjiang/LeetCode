import java.util.*;
public class ThreeSumClosest {
	public static int threeSumClosest1(int[] nums, int target) {
        int res = 0;
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
        	int k = nums[i];
        	if(!ht.containsKey(nums[i])) {
        		ht.put(k, 1);
        	}else {
        		ht.put(k, ht.get(k) + 1);
        	}
        }
        boolean a = false;
        boolean b = false;
        
        for(int i = 0; i < 10000; i++) {
        	a = isCorrect(target + i, ht, nums);
        	b = isCorrect(target - i, ht, nums);
        	if(a) {
        		res = target + i;
        		break;
        	}
        	if (b) {
        		res = target - i;
        		break;
        	}
        }
        
        return res;
    }
	
	public static boolean isCorrect(int target, Hashtable<Integer, Integer> ht, int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				int first = nums[i];
				int second = nums[j];
				int third = target - nums[i] - nums[j];
				ht.put(first, ht.get(first) - 1);
				ht.put(second, ht.get(second) - 1);
				if(ht.containsKey(third) && ht.get(third) > 0) {
					return true;
				}
				ht.put(first, ht.get(first) + 1);
				ht.put(second, ht.get(second) + 1);
			}
		}
		return false;
	}
	
	public static int threeSumClosest2(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = nums[0] + nums[1] + nums[2];
		for(int i = 0; i < nums.length - 2; i++) {
			int cur = calculateClosestVal(nums, target, i);
			if(Math.abs(target - cur) < Math.abs(target - sum)) {
				sum = cur;
			}
		}
		return sum;
	}
	
	public static int calculateClosestVal(int[] nums, int target, int start) {
		int closest = Integer.MAX_VALUE;
		int left = start + 1;
		int right = nums.length - 1;
		int result = 0;
		while(left < right) {
			int current = nums[left] + nums[right]  + nums[start];
			if(Math.abs(target - current) < closest) {
				closest = Math.abs(target - current);
				result = current;
			}
			if(current < target) {
				left++; 
			}else if (current > target) {
				right--;
			}else {
				break;
			}
			
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int n = threeSumClosest2(nums, 1);
		System.out.println(n);
	}
	
}
