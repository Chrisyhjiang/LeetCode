class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<List<String>> dp = new ArrayList<>();
        int longest = 1;
        for (int i = 0; i < n; i++) {
            List<String> ans = new ArrayList<>();
            ans.add(words[i]);
            dp.add(ans);
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && check(words[i], words[j])) {
                    if (1 + dp.get(j).size() > dp.get(i).size()) {
                        dp.set(i, new ArrayList<>(dp.get(j)));
                        dp.get(i).add(words[i]);
                        longest = Math.max(longest, dp.get(i).size());
                    }
                }
            }
        }

        
        List<String> res = new ArrayList<>();
        for (List<String> ls: dp) {
             if (ls.size() == longest) {
                 res.addAll(ls);
                 break;
             }
        }
        return res;
    }

    public boolean check(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if (len1 != len2) {
            return false;
        }
        int dist = 0;
        for (int i = 0; i < len1; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
            if (dist > 1) {
                return false;
            }
        }
        return dist == 1;
    }
}