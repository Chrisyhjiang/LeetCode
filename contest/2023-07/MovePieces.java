// https://leetcode.com/contest/weekly-contest-301/problems/move-pieces-to-obtain-a-string/
public class MovePieces {
	
	public static void main (String[] args) {
		String start = "R_L_";
		String target = "__LR";
		boolean res = canChange(start, target);
		System.out.println(res);
	}
	
	public static boolean canChange(String s, String e) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i), b = e.charAt(i);
            if (a == 'L') {
                left++;
            } else if (a == 'R') {
                right++;
            }
            
            if (b == 'L') {
                left--;
            } else if (b == 'R') {
                right--;
            }
            if (right < 0 || (left != 0 && right != 0))  return false;
        }
        return left == 0 && right == 0;
    }
	public static boolean canChange2(String start, String target) {
		if(start.equals(target)) {
			return true;
		}
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
