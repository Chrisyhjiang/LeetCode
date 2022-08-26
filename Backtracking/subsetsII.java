// https://leetcode.com/problems/subsets-ii/
import java.util.*;
public class subsetsII {
	static List<List<Integer>> res;
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		List<List<Integer>> ans = subsetsWithDup(nums);
		for(List<Integer> ls: ans) {
			for(int e: ls) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, new LinkedList<Integer>(), 0);
        return res;
    }
	
	public static void backtrack(int[] nums, LinkedList<Integer> cur, int pointer) {
		if(pointer > nums.length - 1) {
			res.add(new LinkedList<Integer>(cur));
		}else {
			// increment pointer to the next greater number. 
			int pointer2 = pointer;
			while(pointer2 < nums.length - 1 && nums[pointer2] == nums[pointer2 + 1]) {
				pointer2++;
			}
			
			// either choose to include this number or ignore all of the same number from this point forward. 
			backtrack(nums, cur, pointer2 + 1);
			cur.add(nums[pointer]);
			backtrack(nums, cur, pointer + 1);
			cur.removeLast();
		}
	}
	
}
