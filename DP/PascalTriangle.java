// https://leetcode.com/problems/pascals-triangle/
// https://leetcode.com/problems/pascals-triangle-ii/
import java.util.*;
public class PascalTriangle {

	public static void main(String[] args) {
		List<Integer> k = generate2(3); 
		for(int e: k) {
			System.out.println(e + " ");
		}
	}
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(numRows == 1) {
			List<Integer> row1 = new ArrayList<Integer>();
			row1.add(1);
			res.add(row1);
		}else if (numRows == 2) {
			List<Integer> row1 = new ArrayList<Integer>();
			List<Integer> row2 = new ArrayList<Integer>();
			row1.add(1);
			row2.add(1);
			row2.add(1);
			res.add(row1);
			res.add(row2);
		}else {
			List<Integer> row1 = new ArrayList<Integer>();
			List<Integer> row2 = new ArrayList<Integer>();
			row1.add(1);
			row2.add(1);
			row2.add(1);
			res.add(row1);
			res.add(row2);
			for(int i = 3; i <= numRows; i++) {
				ArrayList<Integer> prev = (ArrayList<Integer>) res.get(res.size() -1);
				List<Integer> newRow = new ArrayList<Integer>();
				for(int j = 0; j < prev.size(); j++) {
					if(j == 0) {
						newRow.add(1);
					}else {
						newRow.add(prev.get(j) + prev.get(j -1));
					}
				}
				newRow.add(1);
				res.add(newRow);
			}
		}
		return res;
		
    }
	public static List<Integer> generate2(int rowIndex) {
		if(rowIndex == 0) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			return row;
		}else if(rowIndex == 1) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			row.add(1);
			return row;
		}else {
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			cur.add(1);
			int step = 2;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			while(step <= rowIndex) {
				temp.addAll(cur);
				cur.clear();
				for(int i = 0; i < temp.size(); i++) {
					if(i == 0) {
						cur.add(1);
					}else {
						cur.add(temp.get(i) + temp.get(i-1));
					}
				}
				cur.add(1);
				step++;
				temp.clear();
			}
			return cur;
		}
	}

}
