class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<> ();
        for (int e: asteroids) {
            if (e > 0) {
                st.push(e);
            } else {
                boolean found = false;
                while (!st.isEmpty()) {
                    if (st.peek() > 0) {
                        if (st.peek() + e > 0) {
                            found = true;
                            break;
                        } else if (st.peek() + e == 0) {
                            found = true;
                            st.pop();
                            break;
                        } else {
                            st.pop();
                        }
                    } else {
                        break;
                    }
                }
                if (!found) {
                    st.push(e);
                }
            }
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
