// https://leetcode.com/problems/restore-ip-addresses/description/
class Solution {
    public boolean valid(String s, int start, int length) {
        return length == 1 || 
            (s.charAt(start) != '0' && 
             (length < 3 || 
              s.substring(start, start + length).compareTo("255") <= 0));
    }
    
    public void helper(String s, int startIndex, List<Integer> dots, List<String> ans) {
        int x = s.length() - startIndex;
        int y = 4 - dots.size();
        if (x > y * 3 || 
            x < y) {
            return;
        }
        if (dots.size() == 3) {
            if (valid(s, startIndex, x)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for (Integer dot : dots) {
                    sb.append(s.substring(last, last + dot));
                    last += dot;
                    sb.append('.');
                }
                sb.append(s.substring(startIndex));
                ans.add(sb.toString());
            }
            return;
        }
        for (int i = 1; i <= 3 && i <= x; ++i) {
            dots.add(i);
            if (valid(s, startIndex, i)) {
                helper(s, startIndex + i, dots, ans);
            }
            dots.remove(dots.size() - 1);
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;   
    }
}