// https://leetcode.com/problems/triangle/
import java.util.*;
public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> ls = new ArrayList<List<Integer>>();
		List<Integer> cur1 = new ArrayList<Integer>();
		List<Integer> cur2 = new ArrayList<Integer>();
		List<Integer> cur3 = new ArrayList<Integer>();
		List<Integer> cur4 = new ArrayList<Integer>();
		cur1.add(2);
		cur2.add(3);
		cur2.add(4);
		cur3.add(6);
		cur3.add(5);
		cur3.add(7);
		cur4.add(4);
		cur4.add(1);
		cur4.add(8);
		cur4.add(3);
		ls.add(cur1);
		ls.add(cur2);
		ls.add(cur3);
		ls.add(cur4);
		int m = minimumTotal(ls);
		System.out.println(m);
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		if(len == 1) {
			return triangle.get(0).get(0);
		}else if (len == 2) {
			return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));
		}else {
			List<Integer> prev = triangle.get(len - 1);
	        List<Integer> DP = new ArrayList<Integer>();
	        
	        for(int i = len - 2; i >= 0; i--) {
	        	List<Integer> row = triangle.get(i);
	        	for(int j = 0; j < row.size(); j++) {
	        		int cur = row.get(j)  + Math.min(prev.get(j), prev.get(j+1));
	        		DP.add(cur);
	        	}
	        	prev.clear();
	        	prev.addAll(DP);
	        	DP.clear();
	        }
	        return prev.get(0);
		}
        
    }

}
