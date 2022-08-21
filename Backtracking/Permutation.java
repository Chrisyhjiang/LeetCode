import java.util.*;
public class Permutation {
	static List<List<Integer>> res;
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> ans = permute(nums);
		for(List<Integer> ls: ans) {
			for(int e: ls) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        ArrayList<Integer> remaining = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	remaining.add(nums[i]);
        }
        ArrayList<Integer> ls = new ArrayList<Integer>();
        backtrack(ls, remaining);
        return res;
    }
	
	public static void backtrack(List<Integer> ls, List<Integer> remaining) {
		if(remaining.size() == 0) {
			res.add(new ArrayList<Integer>(ls));
		}else {
			int k = remaining.remove(remaining.size() - 1);
			for(int j = 0; j <= ls.size(); j++) {
				ls.add(j, k);
				backtrack(ls, remaining);
				ls.remove(Integer.valueOf(k));
			}
			remaining.add(k);
		}
	}
}
