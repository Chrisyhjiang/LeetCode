import java.util.*;

class contest {
	public static long minimumCost(int[] nums) {
        long total = 0L;
        long avg = 0L; 
        
        for (int x: nums) {
            total += (long)x;
        }
        avg = total / (long)nums.length;
        long tmp = avg + 1;
        while (tmp < 1e9 && !isPalindrome(tmp)) {
            tmp++;
        }
        long Cost1 = getScore(nums, tmp);
        long tmp2 = avg; 
        while (tmp2 < 1e9 && !isPalindrome(tmp2)) {
            tmp2--;
        }
        long Cost2 = getScore(nums, tmp2);
        return Long.min(Cost1, Cost2);
        
    }
    
    public static boolean isPalindrome(long l) {
        String s = Long.toString(l);
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    public static long getScore(int[] nums, long score) {
        if (score == 1e9) {
            return Long.MAX_VALUE;
        }
        long res = 0l;
        for (int n: nums) {
            res += (long)Math.abs(score - n);
        }
        return res;
    }
    
    
    
    public static void main(String[] args) {
    	int[] arr = {4,3,1};
    	long res = minimumCost(arr);
    	System.out.println(res);
    }
}