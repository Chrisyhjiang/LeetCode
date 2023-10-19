class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ls = new ArrayList<>();
        int c = -1;
        // because 0 1 alternating does not matter where you start with
        // if the beginning is 0 then you must look for a 1 after 
        // there would be no point to look for a 1 as start because a 0 must always preceed a 0
        for (int i = 0; i < n; i++) {
            if (groups[i] != c) {
                c = groups[i];
                ls.add(words[i]);
            }
        }
        return ls;
    }
}