// https://leetcode.com/problems/combination-sum-ii/
import java.util.*;
public class combSum2 {
	static List<List<Integer>> res;
	static HashSet<String> hs;
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> ans = combinationSum2(candidates, target);
		for(List<Integer> ls : ans) {
			for(int e: ls) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<List<Integer>>();
        sum(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }
	public static void sum(int[] candidates, int target, int start, List<Integer> ls) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(ls));
		}else if (target < 0) {
			return;
		}else {
			int prev = -1;
			for(int i = start; i < candidates.length; i++) {
				if(candidates[i] == prev) {
					continue;
				}
				ls.add(candidates[i]);
				sum(candidates, target - candidates[i], i + 1, ls);
				ls.remove(ls.size() - 1);
				prev = candidates[i];
			}
		}
	}
}
