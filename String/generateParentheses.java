import java.util.*;
public class generateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
        allCombinations(res, "", 0, 0, n);
        return res;
    }
	public static void allCombinations(List<String> ls, String current, int open, int close, int max){
		// using backtracking
		// if the length of the string is = than the max length allowed we add it to the lit
		if(current.length() == 2 * max) {
			ls.add(current);
			return;
		}
		// if the open parentheses is smaller than max allowed then we can add open parentheses
		if(open < max) {
			allCombinations(ls, current + "(", open + 1, close, max);
		}
		// we can add a close parentheses as long as it is smaller than the number of open parentheses.  
		if(close < open) {
			allCombinations(ls, current + ")", open, close + 1, max);
		}
	}
}
