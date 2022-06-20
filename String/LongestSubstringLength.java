import java.util.*;
public class LongestSubstringLength {
	public int lengthOfLongestSubstring(String s) {
        int[] table = new int[128];
        int start = 0;
        int end = 0;
        int result = 0;
        char[] m = s.toCharArray();
        
        while(end < m.length){
            table[m[end]]++;
            
            while(table[m[end]] > 1){
                table[m[start++]]--;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }
	
	public int lengthOfLongestSubstringOptimized(String s) {
        int longest = 0;
        char[] c = s.toCharArray();
        int[] arr = new int[256];
        Arrays.fill(arr,-1);
        int i = 0;
        int j = 1;
        while(i < c.length){    
            int temp = j - i;
            arr[c[i]] = i;
            int k = i + 1;
            // i is the starting point of the current window
            // j is the ending point of the current windown. 
            
            while (j < c.length){
                if(arr[c[j]] < i){
                    arr[c[j]] = j;
                    temp++;
                    j++;
                }else{
                    // advance i before update
                    i = arr[c[j]] + 1;
                    arr[c[j]] = j;
                    j++;
                    break;
                }
            }
            
            i = Math.max(i,k);
            longest = Math.max(temp, longest);
        }
        return longest;
    }
}
