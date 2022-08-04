// https://leetcode.com/problems/longest-palindromic-subsequence/submissions/
public class longestPalindromicSubsequence {
	static int[][] DP;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		int res = longestPalindromeSubseq2("bbbab");
		System.out.println(res);

	}
	public static int longestPalindromeSubseq(String s) {
		// failed
		int bestLength = 1;
		for(int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i;
			int length = 0;
			while(left >= 0 && right < s.length()) {
				if(s.charAt(left) == s.charAt(right)) {
					length = right - left + 1;
					left--;
					right++;
				}else {
					// search those indices;
					int newLeft = left;
					int newRight = right;
					int temp1 = 0;
					while(newLeft >= 0 && newRight < s.length()) {
						if(s.charAt(newLeft) == s.charAt(newRight)) {
							temp1 += 2;
							newRight++;
						}
						newLeft--;
					}
					newLeft = left;
					newRight = right;
					int temp2 = 0;
					while(newLeft >= 0 && newRight < s.length()) {
						if(s.charAt(newLeft) == s.charAt(newRight)) {
							temp2+=2;
							newLeft--;
						}
						newRight++;
					}
					length += Math.max(temp1, temp2);
					break;
				}
			}
			bestLength = Math.max(length, bestLength);
		}
		
		for(int i = 0; i < s.length()-1; i++) {
			int left = i;
			int right = i + 1;
			int length = 0;
			while(left >= 0 && right < s.length()) {
				if(s.charAt(left) == s.charAt(right)) {
					length = right - left + 1;
					left--;
					right++;
				}else {
					// search those indices;
					int newLeft = left;
					int newRight = right;
					int temp1 = 0;
					while(newLeft >= 0 && newRight < s.length()) {
						if(s.charAt(newLeft) == s.charAt(newRight)) {
							temp1 += 2;
							newRight++;
						}
						newLeft--;
					}
					newLeft = left;
					newRight = right;
					int temp2 = 0;
					while(newLeft >= 0 && newRight < s.length()) {
						if(s.charAt(newLeft) == s.charAt(newRight)) {
							temp2+=2;
							newLeft--;
						}
						newRight++;
					}
					length += Math.max(temp1, temp2);
					break;
				}
			}
			bestLength = Math.max(length, bestLength);
		}
		return bestLength;
    }
	
	public static int longestPalindromeSubseq2(String s) {
		int len = s.length();
		DP = new int[len][len];
		for(int i = 0; i < len; i++) {
			DP[i][i] = 1;
		}
		segment(s, 0, len-1);
		for(int[]arr: DP) {
			for(int n: arr) {
				max = Math.max(n, max);
			}
		}
		
		return max;
	}
	
	public static int segment(String s, int left, int right) {
		if(left == right) {
			return DP[left][right];
		}
		if(right - left == 1) {
			if(s.charAt(left) == s.charAt(right)) {
				 DP[left][right] = 2;
				return 2;
			}
		}
		
		if(s.charAt(left) == s.charAt(right)) {
			if(DP[left+1][right-1] != 0) {
				DP[left][right] = DP[left+1][right-1] + 2;
			}else {
				DP[left+1][right-1] = segment(s, left+1, right - 1);
				DP[left][right] = DP[left+1][right-1] + 2;
			}
		}else {
			int l = -1; 
			int r = -1;
			if(DP[left+1][right] != 0) {
				l = DP[left+1][right];
			}else {
				DP[left+1][right] = segment(s, left + 1, right);
				l = DP[left+1][right];
			}
			
			if(DP[left][right-1] != 0) {
				r = DP[left][right-1];
			}else {
				r = segment(s, left, right-1);
			}
			
			DP[left][right] = Math.max(l, r);
		}
		return DP[left][right];
	}
	
}
