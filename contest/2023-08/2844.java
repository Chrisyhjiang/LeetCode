// https://leetcode.com/problems/minimum-operations-to-make-a-special-number/description/
class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        TreeSet<Integer> zeros = new TreeSet<>();
        TreeSet<Integer> fives = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '0') {
                zeros.add(i);
            } else if (c == '5') {
                fives.add(i);
            }
        }
        int minOp = n;
        for (int i = 0; i < n; i++) {
            char cur = num.charAt(i);
            if (cur == '2' || cur == '7') {
                Integer idx = fives.higher(i);
                if (idx != null) {
                    int op = (idx - i - 1) + (n - idx - 1);
                    minOp = Math.min(minOp, op);
                }
            } else if (cur == '5') {
                Integer idx = zeros.higher(i);
                if (idx != null) {
                    int op = (idx - i - 1) + (n - idx - 1);
                    minOp = Math.min(minOp, op);
                }
            } else if (cur == '0') {
                Integer idx = zeros.higher(i);
                if (idx != null && idx != i) {
                    int op = (idx - i - 1) + (n - idx - 1);
                    minOp = Math.min(minOp, op);
                }
            }
        }
        if (minOp == n && !zeros.isEmpty()) {
            minOp -= 1;
        }
        return minOp;
    }
}
