class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int j = 0;
        for (int i = 0; i < len1 && j < len2; i++) {
            int c = str1.charAt(i) - 'a';
            int d = str2.charAt(j) - 'a';
            if (c == d ||  (c + 1) % 26 == d) {
                j++;
            }
        }
        return j == len2;
    }
}