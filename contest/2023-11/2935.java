class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int res = 0;
        for (int i = 20; i >= 0; i--) {
            res <<= 1;
            HashMap<Integer, Integer> p = new HashMap<>();
            HashMap<Integer, Integer> p2 = new HashMap<>();

            for (int a: nums) {
                int x = a >> i;
                if (!p.containsKey(x)) {
                    p.put(x, a);
                    p2.put(x, a);
                }
                p.put(x, Math.min(p.get(x), a));
                p2.put(x, Math.max(p2.get(x), a));
            }
            for (int x: p.keySet()) {
                int y = res ^ 1 ^ x;
                if (x >= y && p.containsKey(y) && p.get(x) <= p2.get(y) * 2) {
                    res |= 1;
                    break;
                }
            }

        }

       
        return res;
    }
}