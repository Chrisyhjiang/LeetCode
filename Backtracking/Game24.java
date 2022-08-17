import java.util.*;

public class Game24 {

	public static void main(String[] args) {
		int[] arr = {1,9,1,2};
		boolean ans = judgePoint24(arr);
		System.out.println(ans);
		
	}
	public static boolean judgePoint24(int[] cards) {
		ArrayList<Double> ls = new ArrayList<Double>();
		double[] arr = new double[cards.length];
		for(int i = 0; i < cards.length; i++) {
			double d = Double.valueOf(cards[i]);
			arr[i] = d;
			ls.add(d);
		}
		boolean res = backtrack(ls, 0.0) || twoBrackets(arr);
		return res;
    }
	
	public static boolean backtrack(ArrayList<Double> ls, double cur) {
		if(ls.size() == 0) {
			return cur - 24 <= 0.001;
		}else {
			for(int i = ls.size() - 1; i >= 0; i--) {
				double a = ls.remove(i);
				boolean b, c, d, e;
				if(cur == 0) {
					b = backtrack(ls, a);
					c = b;
					d = b;
					e = b;
				}else {
					b = backtrack(ls, cur + a);
					c = backtrack(ls, cur - a) || backtrack(ls, a - cur);
					d = backtrack(ls, cur * a);
					e = backtrack(ls, cur / a) || backtrack(ls, a / cur);
				}
				
				if(b || c || d || e) {
					return true;
				}
				ls.add(a);
			}
			return false;
		}
	}
	
	public static boolean twoBrackets(double[] cards) {
		boolean res = false;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					
				}
			}
		}
		
	}
	
	public static boolean is24(int first, int second) {
		if(first + second == 24) {
			return true;
		}else if (first - second == 24 || second - first == 24) {
			return true;
		}else if(first * second == 24) {
			return true;
		}else if (first / second == 24 || second / first == 24) {
			return true;
		}else {
			return false;
		}
	}


	

}
