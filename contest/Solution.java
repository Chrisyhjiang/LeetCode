import java.util.*;
class Solution {
	public static long maximumSumOfHeights(List<Integer> maxHeights) {
		int n = maxHeights.size();
		long[] left = new long[n];
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		long res = 0;
		long cur = 0;
		
		// monostack 
		// iterate from 0 to n - 1 assuming A[i] is the highest
		// populates from left to right. 
		for (int i = 0; i < n; i++) {
			// track the index so we can find how many of the same level. 
			while (st.size() > 1 && maxHeights.get(st.peek()) > maxHeights.get(i)) { 
				int j = st.pop();
				cur -= 1L * (j - st.peek()) * maxHeights.get(j);
			}
			cur += 1L * (i - st.peek()) * maxHeights.get(i);
			st.push(i);
			left[i] = cur;
		}
		st.clear();
		st.push(n);
		cur = 0;
		// iterate from n - 1 to 0, again assuming a[i] is the highest. 
		// populates from right to left. 
		for (int i = n - 1; i >= 0; i--) {
			// track the index so we can find how many of the same level. 
			while(st.size() > 1 && maxHeights.get(st.peek()) > maxHeights.get(i)) {
				int j = st.pop();
				cur += 1L * (j - st.peek()) * maxHeights.get(j);
			}
			cur -= 1L * (i - st.peek()) * maxHeights.get(i);
			st.push(i);
			// overcounted the current pivot twice with left and cur. asdf
			res = Math.max(res, left[i] + cur - maxHeights.get(i));
		}
		return res;
		
    }
    
    
    
    public static void main(String[] args) {
    	List<Integer> ls = new ArrayList<Integer>();
    	ls.add(6);
    	ls.add(5);
    	ls.add(3);
    	ls.add(9);
    	ls.add(2);
    	ls.add(7);
    	// upHill: 6, 11, 14, 17, 19, 21
    	// downHill: 17,15,13,11,9,7

    	long res = maximumSumOfHeights(ls);
    	System.out.println(res);
    }

}

