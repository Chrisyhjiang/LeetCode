// https://leetcode.com/problems/evaluate-reverse-polish-notation/
import java.util.*;
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = {"3", "11", "+", "5", "-"};
		int a = evalRPN(tokens);
		System.out.println(a);
	}
	
	public static int evalRPN(String[] tokens) {
		if(tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}else {
			int res = calculate(tokens, 0, tokens.length - 1);
			return res;
		}
    }
	
	public static int calculate(String[] tokens, int left, int right) {
		String symbol = tokens[right];
		right--;
		if(right - left == 1) {
			int l = Integer.parseInt(tokens[left]);
			int r = Integer.parseInt(tokens[right]);
			if(symbol.equals("+")) {
				return l +  r;
			}else if (symbol.equals("-")) {
				return l - r;
			}else if (symbol.equals("*")) {
				return l * r;
			}else {
				return l / r;
			}
		}else {
			String r = tokens[right];
			if(!r.equals("+") && !r.equals("-") && !r.equals("*") && !r.equals("/")) {
				if(symbol.equals("+")) {
					return Integer.parseInt(r) + calculate(tokens, left, right - 1);
				}else if (symbol.equals("-")) {
					return Integer.parseInt(r) - calculate(tokens, left, right - 1);
				}else if (symbol.equals("*")) {
					return Integer.parseInt(r) * calculate(tokens, left, right - 1);
				}else {
					return Integer.parseInt(r) / calculate(tokens, left, right - 1);
				}
			}else {
				int l = Integer.parseInt(tokens[left]);
				if(symbol.equals("+")) {
					return l + calculate(tokens, left + 1, right);
				}else if (symbol.equals("-")) {
					return l - calculate(tokens, left + 1, right);
				}else if (symbol.equals("*")) {
					return l * calculate(tokens, left + 1, right);
				}else {
					return l / calculate(tokens, left + 1, right);
				}
			}
		}
	}
	
	public static int evalRPN2(String[] tokens) {
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < tokens.length; i++) {
			String symbol = tokens[i];
			if(!symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")) {
				st.add(Integer.parseInt(symbol));
			}else {
				if(symbol.equals("+")) {
					st.add(st.pop()+st.pop());
				}else if (symbol.equals("-")) {
					st.add(st.pop()-st.pop());
				}else if (symbol.equals("*")) {
					st.add(st.pop()*st.pop());
				}else {
					st.add(st.pop()/st.pop());
				}
			}
		}
		return st.pop();
	}
}
