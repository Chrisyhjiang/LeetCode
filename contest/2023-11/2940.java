// monostack problem memorize code
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        int[] nextLarger = nextLarger(heights);
        int idx = 0;
        for (int[] query: queries) {
            int left = Math.min(query[0], query[1]);
            int right = Math.max(query[0], query[1]);
            if (heights[left] < heights[right]) {
                res[idx] = right;
            } else if(heights[left] == heights[right]) {
                if (left == right) {
                    res[idx] = right;
                } else {
                    res[idx] = nextLarger[right];
                }
                
            } else {
                boolean found = false;
                while (right < heights.length) {
                    if (right == -1) {
                        break;
                    } else {
                        if (heights[right] > heights[left]) {
                            found = true;
                            break;
                        } else {
                            right = nextLarger[right];
                        }
                    }
                }
                if (!found) {
                    res[idx] = -1;
                } else {
                    res[idx] = right;
                }
            }
            idx++;
        }
        return res;
    }

    public int[] nextLarger(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            res[st.pop()] = -1;
        }
        return res;
    }
}