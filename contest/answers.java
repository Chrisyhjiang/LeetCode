import java.util.*;
public class answers {
	static int[][] st;
	static int[] logTable;
    public static void maxGcdSum(int[] nums, int[][] query) {
        int n = nums.length;
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;
        logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i >> 1] + 1;
        }
        st = new int[n][maxLog];

        for (int i = 0; i < n; i++) {
            st[i][0] = nums[i];
        }

        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = gcd(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
        
        for (int[] q: query) {
        	System.out.println(query(q[0], q[1]));
        }
    }

    public static int query(int L, int R) {
        int j = logTable[R - L + 1];
        return gcd(st[L][j], st[R - (1 << j) + 1][j]);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
    	int[][] query = {{0, 2}, {3, 5}, {1,1}, {2,3}};
    	int[] gcd = {12, 6 , 3, 5, 7, 9};
    	maxGcdSum(gcd, query);
    }

}
