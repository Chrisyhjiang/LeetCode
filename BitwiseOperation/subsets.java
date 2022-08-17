//https://leetcode.com/problems/subsets/submissions/
import java.util.*;
public class subsets {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,};
		List<List<Integer>> ans = subsets(nums);
		for(List<Integer> ls: ans) {
			for(int i: ls) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println(1<<3);

	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < 1<<nums.length; i++) {
			String s = Integer.toBinaryString(i);
			while(s.length() < nums.length) {
				s = "0" + s;
			}
			List<Integer> comb = new ArrayList<Integer>();
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '1') {
					comb.add(nums[j]);
				}
			}
			res.add(comb);
		}
		return res;
    }
	
	
}
