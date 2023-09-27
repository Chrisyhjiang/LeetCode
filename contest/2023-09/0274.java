class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int h = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                return h;
            }
        }
        return h;
    }
}

// 0 1 3 5 6
