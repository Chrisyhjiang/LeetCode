// https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.*;
public class longestConsecutiveSequence {
	static int[] parent;
	public static void main(String[] args) {
		
	}
	
	public static int longestConsecutive(int[] nums) {
		HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums) {
            hs.add(num);
        }

        int max = 0;
        // outter loop O(n)
        for (int n: hs) {
            if (!hs.contains(n-1)) {
                int cur = n;
                int curStreak = 1;
                // while loop only runs when n is the smallest possible number, thus ensuring On complexity
                // thus complexity will be O(2n)
                while (hs.contains(cur+1)) {
                    cur++;
                    curStreak++;
                }

                max = Math.max(curStreak, max);
            }
        }

        return max;
	}
	
	
}
