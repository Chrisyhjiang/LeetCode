class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
       int n = s.length();
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	if	(s.charAt(i) == '1') {
        		ls.add(i);
        	}
        }
        String res = "";
        int minLen = Integer.MAX_VALUE;
        if (ls.size() - k < 0) {
        	return res;
        }
        // 0 4 5 8
        // k = 3
        for (int i = 0; i <= ls.size() - k; i++) {
        	int a = ls.get(i);
        	int b = ls.get(i + k - 1);
        	String cur = s.substring(a, b + 1); 
        	if (b - a + 1 < minLen) {
        		res = cur;
                minLen = b - a + 1;
        	} else if (b - a + 1 == minLen){
        		if (res.compareTo(cur) > 0) {
        			res = cur;
        		}
        	}
        	
        }
        return res;
    }
    
}