// https://leetcode.com/problems/valid-triangle-number/solution/
import java.util.Arrays;

public class validTriangleNumber {

	public static void main(String[] args) {
		int[] arr = {48,66,61,46,94,75};
		int res = triangleNumber(arr);
		System.out.println(res);
	}
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
        	if(nums[i] == 0) {
        		continue;
        	}else {
        		for(int j = i + 1; j < nums.length - 1;j++) {
        			if(nums[j] == 0) {
        				continue;
        			}else {
        				for(int k = j + 1; k < nums.length; k++) {
        					if(nums[k] == 0) {
        						continue;
        					}else {
        						if(nums[i] + nums[j] <= nums[k]) {
                    				break;
                    			}else {
                    				count++;
                    			}
        					}
                		}	
        			}
            	}
        	}
        	
        }
        return count;
        
    }
	public static int triangleNumber2(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			for(int j = i + 1; j < nums.length - 1; j++) {
				int k = binSearch(j + 1, nums.length - 1, nums, nums[i] + nums[j]);
				count += k - j - 1;
			}
		}
		return count;
	}
	
	public static int binSearch(int start, int end, int[] nums, int target) {
		while (end >= start && end < nums.length) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
	}
	
}
