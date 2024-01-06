class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        // one of the thing
        res = new ArrayList<>(); 
        int n = s.length();
        boolean[][] DP = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                DP[i][j] = isPalindrome(s.substring(i, j + 1));
            }
        }
        calculate(s, DP, 0, new ArrayList<String>());
        return res;

    }

    public void calculate(String s, boolean[][] DP, int i, ArrayList<String> ls) {
        if (i == s.length()) {
            res.add(new ArrayList<String>(ls));
        }

        for (int k = i; k < s.length(); k++) {
            if (DP[i][k]) {
                ls.add(s.substring(i, k + 1));
                calculate(s, DP, k + 1, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}