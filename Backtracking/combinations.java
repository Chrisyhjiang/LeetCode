// https://leetcode.com/problems/combinations/submissions/
import java.util.*;
public class combinations {
	
	static List<List<Integer>> res;
	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		List<List<Integer>> ans = combine(n,k);
		for(List<Integer> ls: ans) {
			for(int i: ls) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<List<Integer>>();
        backtrack(1, new ArrayList<Integer>(), k, n);
        return res;
    }
	
	public static void backtrack(int start, List<Integer> ls, int k, int n) {
		if(ls.size() == k) {
			res.add(new ArrayList<Integer>(ls));
		}else {
			if(!ls.isEmpty()) {
				start = ls.get(ls.size() - 1) + 1;
			}
			for(int i = start; i <= n; i++) {
				ls.add(i);
				backtrack(start + 1, ls, k, n);
				ls.remove(ls.size() - 1);
			}
		}
	}
}
