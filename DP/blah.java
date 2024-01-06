import java.util.*;
public class blah {
	public static int maximumLength(String s) {
        int maxLen = -1; 
        int right = 0;
        int left = 0; 
        String cur = "";
        int[] lps = buildLPS(s);
        while (right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                cur += s.charAt(right);
                if (cur.length() > maxLen) {
                    int x = countSubstrings(s.substring(left), cur, lps, left);
                    if (x >= 3) {
                        maxLen = cur.length();
                    }
                }
            } else {
                cur = "";
                left = right;
                continue;
            }
            right++;
        }

        return maxLen; 
    }

    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private static int countSubstrings(String word, String pattern, int[] lps, int idx) {
        int n = word.length();
        int m = pattern.length();
        int count = 0;
        int i = idx;
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == word.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                count++;
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != word.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
    	PriorityQueue<Integer> reversePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        // Add elements to the reverse priority queue
        reversePriorityQueue.add(10);
        reversePriorityQueue.add(5);
        reversePriorityQueue.add(20);

        // Remove and print the smallest element (which is the root in a max heap)
        int smallest = reversePriorityQueue.poll();
        System.out.println("Removed smallest element (root): " + smallest);
       
        
        
    }

}
