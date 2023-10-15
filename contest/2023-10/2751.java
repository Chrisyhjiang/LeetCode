class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> robotIdx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            robotIdx.add(i);
        }

        Collections.sort(robotIdx, (a, b) -> (positions[a] - positions[b]));

        Stack<Integer> st = new Stack<Integer>();
        for (int i : robotIdx) {
            if (directions.charAt(i) == 'R') {
                st.push(i);
                continue;
            }
            while(!st.isEmpty() && healths[i] > 0) {
                if (healths[st.peek()] < healths[i]) {
                    healths[st.pop()] = 0;
                    healths[i] -= 1;
                } else if (healths[st.peek()] > healths[i]) {
                    healths[st.peek()] -= 1;
                    healths[i] = 0;
                }else{
                    healths[st.pop()] = 0;
                    healths[i] = 0;
                }
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for (int h: healths) {
            if (h > 0) {
                res.add(h);
            }
        }
        return res;
    }
}