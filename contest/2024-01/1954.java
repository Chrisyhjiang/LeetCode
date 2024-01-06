class Solution {
    public long minimumPerimeter(long neededApples) {
        long i = 1;
        long j = 100000;
        while (i < j) {
            long m = (i + j) / 2;
            long apples = m * (m + 1) * (4*m + 2);
            if (apples < neededApples) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return 8 * i;
    }


}