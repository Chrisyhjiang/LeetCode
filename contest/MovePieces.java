// https://leetcode.com/contest/weekly-contest-301/problems/move-pieces-to-obtain-a-string/
public class MovePieces {
	
	public static void main (String[] args) {
		String start = "_L__R__R_";
		String target = "L______RR";
		boolean res = canChange2(start, target);
		System.out.println(res);
	}
	
	public static boolean canChange(String start, String target) {
		char[] st = start.toCharArray();
		char[] ta = target.toCharArray();
	
        for(int i = 0; i < start.length(); i++) {
        	char current = st[i];
        	char goal = ta[i];
        	if(current == goal) {
        		continue;
        	}else {
        		if(current == '_') {
        			// search right if L search left if R
        			if(goal == 'L') {
        				for(int j = i; j < st.length; j++) {
        					if(st[j] == 'R') {
        						return false;
        					}else if (st[j] == 'L') {
        						st[i] = 'L';
        						st[j] = '_';
        						break;
        					}
        				}
        				continue;
        			}else {
        				return false;
        			}
        		}else if (current == 'L') {
        			return false;
        		}else {
        			if(goal == '_') {
        				for(int j = i; j < st.length; j++) {
        					if(st[j] == 'L') {
        						return false;
        					}else if (st[j] == '_') {
        						s
        					}
        				}
        			}else {
        				return false;
        			}
        		}
        	}
        	
        }
		return true;
		
    }
	public static boolean canChange2(String start, String target) {
		char[] dest = target.toCharArray();
		char[] src = start.toCharArray();
		
		int ldest = 0;
		int lsrc = 0;
		int rdest = 0;
		int rsrc = 0;
		for(int i = 0; i < src.length; i++) {
			if(src[i] == 'L') {
				lsrc++;
			}else if (src[i] == 'R'){
				rsrc++;
			}
			
			if(dest[i] == 'L') {
				ldest++;
			}else if (dest[i] == 'R'){
				rdest++;
			}
		}
		if(lsrc != ldest || rsrc != rdest) {
			return false;
		}else {
			int n = start.length();
			int j = 0;
			for(int i = 0; i < n; i++) {
				if(dest[i] == 'L') {
					while(j < n) {
						if(src[j] != '_') {
							break;
						}
						j++;
					}
					if(src[j] == 'L') {
						if(j < i) {
							return false;
						}else {
							src[i] = src[j];
							src[j] = '_';
						}
					}else {
						if(j >= i) {
							return false;
						}
					}
				}
			}
			
			int k = n - 1;
			for(int i = n - 1; i >= 0; i--) {
				if(dest[i] == 'R') {
					while(k >= 0) {
						if(src[k] != '_') {
							break;
						}
						k--;
					}
					if(src[k] == 'R') {
						if(k > i) {
							return false;
						}else {
							src[i] = src[k];
							src[k] = '_';
						}
					}else {
						if(k <= i) {
							return false;
						}
					}
				}
			}
			return true;
		}
		
		
	}
}
