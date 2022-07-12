// https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,1,1};
		int target = 11;
		int n = minSubArrayLen2(target, arr);
		System.out.println(n);
		
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
        int min = (int) (1e5 + 1);
        for(int i = 0; i < nums.length ; i++) {
        	int sum = nums[i];
        	if(sum >= target) {
        		min = 1;
        		break;
        	}else {
        		for(int j = i + 1; j < nums.length; j++) {
            		sum += nums[j];
            		if(sum >= target) {
            			min = Math.min(j - i + 1, min);
            			break;
            		}
            	}
        	}
        	
        }
        if(min < 1e5 + 1) {
        	return min;
        }else {
        	return 0;
        }
    }
	
	public static int minSubArrayLen2(int target, int[] nums) {
		int min = (int) (1e5 + 1);
		int left = 0;
		int right = 0;
		int sum = nums[0];
		while(left <= right && right < nums.length) {
			// increase right since sum is smaller
			
			while(sum < target && right < nums.length - 1) {
				right++;
				sum += nums[right];
			}
			if(sum >= target) {
				min = Math.min(min, right - left + 1);
			}
			sum -= nums[left];
			left++;
		}
		if (min == (int) (1e5 + 1)) {
			return 0;
		}else {
			return min;
		}
		
	}

	public static void printTriangle(int n) {
		String s = "";
		for(int i = 0; i < n; i++) {
			s += "*";
			System.out.println(s);
		}
	}
	
	public static void printTriangle2(int n) {
		if(n == 0) {
			return;
		}else if (n == 1) {
			System.out.println("*");
		}else{
			printTriangle2(n - 1);
			String s = "";
			for(int i = 0; i < n; i++) {
				s += "*";
			}
			System.out.println(s);
		}
	}
}
