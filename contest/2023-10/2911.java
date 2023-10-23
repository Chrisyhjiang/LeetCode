class Solution {
		int MX = 201;
		ArrayList<Integer>[] divisors;
		// getModify gets the min number of changes in order to switch a string into a semi-palindrome
		public int getModify(String s) {
			int n = s.length();
			int minCnt = Integer.MAX_VALUE;
			// brute force through all the divisors
			for (int d: divisors[n]) {
				int cnt = 0;
				// calculate each parity.
				for (int i = 0; i < d; i++) {
					String t = "";
					for (int j = i; j < n; j += d) {
						t += s.charAt(j);
					}
					// since a semi-palindrome can be seen as a lot of palindromes interlaced 
					for (int k = 0; k < t.length() / 2; k++) {
						if (t.charAt(k) != t.charAt(t.length() - 1 - k)) {
							cnt += 1;
						}
					}
				}
				minCnt = Math.min(minCnt, cnt);
			}
			return minCnt; 
		}

    public int minimumChanges(String s, int k) {
				// divisors calcualtes from 1 -> 200 what its divisors are going vertical
        divisors = new ArrayList[MX];
				int n = s.length();
				for (int i = 0; i < MX; i++) {
					divisors[i] = new ArrayList<Integer>();
				}
				for (int i = 1; i < MX; i++) {
					for (int j = 2 * i; j < MX; j+=i) {
						divisors[j].add(i);
					}
				}

				// n - 1 because a semi-palindrome has to be at least length 2
				int[][] modify = new int[n][n];
				for (int left = 0; left < n - 1; left++) {
					// this ensures everything is at least length of 2
					for (int right = left + 1; right < n; right++) {
						String m = s.substring(left, right + 1);
						modify[left][right] = getModify(m);
					}
				}
				// DP logic:
				// i stands for the number of CUTS REMAINING
				// j stands for from s.substring(0, j) is what we we are partitioning on. 
				int[][] DP = new int[n][n];
				DP[0] = modify[0];
				for (int i = 1; i < k; i++) {
					for (int j = 2 * i + 1; j < n; j++) {
						int res = Integer.MAX_VALUE;
						// 1 partition can start at [i * 2] to j - 1.
						for (int l = i * 2; l < j; l++) {
							res = Math.min(res, DP[i-1][l-1] + modify[l][j]);
						}
						DP[i][j] = res;
					}
				}
				// k parts means k - 1 cuts n - 1 for index. 
				return DP[k-1][n-1];
    }

		
}