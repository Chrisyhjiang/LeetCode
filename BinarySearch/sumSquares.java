
public class sumSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            // binary search for the target. loop square. 
            
            if (bsearch(0, b, b))
                return true;
        }
        return false;
    }
    public boolean bsearch(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return bsearch(s, mid - 1, n);
        return bsearch(mid + 1, e, n);
    }
}
