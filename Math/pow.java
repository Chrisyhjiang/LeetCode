import java.util.HashMap;

// https://leetcode.com/problems/powx-n/
public class pow {
	static HashMap<Integer, Double> DP;
	public static void main(String[] args) {
		double d = myPow2(2, 10);
		System.out.println(d);
	}
	public double myPow(double x, int n) {
		if(x == 1) {
			return 1.0;
		}
		if(x == -1) {
			if(Math.abs(n) % 2 == 1) {
				return -1;
			}else {
				return 1;
			}
		}
        double res = 1.0;
        if(n == 0) {
        	return 1;
        }else if (n < 0) {
        	if(n <= 20000) {
        		return 0.0;
        	}
        	for(int i = 0; i < Math.abs(n); i++) {
        		res /= x;
        	}
        }else {
        	for(int i = 0; i < Math.abs(n); i++) {
        		res *= x;
        	}
        }
        
        return res;
    }
	
	public static double myPow2(double x, int n) {
		if(x == 1) {
			return 1;
		}
		if(n == 0) {
			return 1;
		}
		if(x == -1) {
			if(n%2 == 1) {
				return -1;
			}else {
				return 1;
			}
		}else {
			long N = n;
			if(N < 0) {
				x = 1/x;
				N = -N;
			}
			double ans = 1;
			double current = x;
			for(long i = N; i > 0; i = i>>2) {
				if(i % 2 == 1) {
					ans *= current;
				}
				current *= current;
			}
			return ans;
		}
		 
		
	}
	
}
