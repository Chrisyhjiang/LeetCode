// https://leetcode.com/problems/find-all-duplicates-in-an-array/
import java.util.*;
public class findAllDuplicates {

	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};
		ArrayList<Integer> ls = (ArrayList<Integer>) findDuplicates(arr);
		for(int e: ls) {
			System.out.println(e);
		}
	}
	public static List<Integer> findDuplicates(int[] nums) {
		// special input allows the value of the array to be used as the index. 
		// if the value is negative, add the index + 1; s
		// else make the value negative. 
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if(nums[index] < 0) {
				res.add(index + 1);
			}else {
				nums[index] = -nums[index];
			}
			 
		}
		return res;
    }
}
