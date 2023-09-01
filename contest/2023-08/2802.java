// https://leetcode.com/problems/find-the-k-th-lucky-number/description/
class Solution {
    public String kthLuckyNumber(int k) {
        String m = Integer.toBinaryString(k+1);
        String res = "";
        for(int i = 1; i < m.length(); i++) {
            res += (m.charAt(i) == '1') ? '7' : '4';
        }
        return res;
    }
}
