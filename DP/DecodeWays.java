// https://leetcode.com/problems/decode-ways/
public class DecodeWays {

	public static void main(String[] args) {
		String s = "31";
		int k = numDecodings(s);
		System.out.println(k);
	}
	public static int numDecodings(String s) {
        int len = s.length();
        if(len == 1) {
        	if(s.charAt(0) != '0') {
        		return 1;
        	}else {
        		return 0;
        	}
        }else if (len == 2) {
        	int k = Integer.parseInt(s);
        	if(k < 10) {
        		return 0;
        	}else if (k <= 26) {
        		if(k == 10 || k == 20) {
        			return 1;
        		}else {
        			return 2;
        		}
        	}else {
        		if(k % 10 == 0) {
        			return 0;
        		}else {
        			return 1;
        		}
        	}
        }
        
        int[] DP = new int[len + 1];
        DP[len] = 1;
        if(s.charAt(len - 1) != '0') {
        	DP[len - 1] = 1;
        }else {
        	DP[len - 1] = 0;
        }
        
        for(int i = len - 2; i >= 0; i--){
        	if(s.charAt(i) != '0') {
        		int m = Integer.parseInt("" + s.charAt(i) + s.charAt(i + 1));
        		if(m <= 26 && m > 0) {
        			DP[i] = DP[i + 1] + DP[i + 2];
        		}else {
        			DP[i] = DP[i + 1];
        		}
        	}else {
        		DP[i] = 0;
        	}
        }
        
        return DP[0];
    }
}
