// https://leetcode.com/problems/combination-sum/
import java.util.*;
public class combinationSum {
	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 8;
		List<List<Integer>> res = combinationSum(candidates, target);
		for(List<Integer> ls: res) {
			for(int e: ls) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		sum(candidates, target, new ArrayList<Integer>(), 0, res);
		return res;
    }
	// backtracking to remove the last number in the list. 
	public static void sum(int[] candidates, int target, ArrayList<Integer> ls, int start, List<List<Integer>> res){
		if(target == 0) {
			res.add(new ArrayList<Integer>(ls));
		}else if (target < 0){
			return;
		}else {
			for(int i = start; i < candidates.length; i++) {
				ls.add(candidates[i]);
				sum(candidates, target - candidates[i], ls, i, res);
				ls.remove(ls.size() - 1);
			}
		}
		
	}
}
