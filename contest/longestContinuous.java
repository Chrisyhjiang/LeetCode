
public class longestContinuous {

	public static void main(String[] args) {
		String s = "a";
		int res = longestContinuousSubstring(s);
		System.out.println(res);

	}
	
	public static int longestContinuousSubstring(String s) {
		if(s.length() == 0) {
			return 0;
		}
		int localMax = 1;
		int globalMax = 1;
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) - s.charAt(i-1) == 1) {
				localMax ++;
			}else {
				localMax = 1;
			}
			globalMax = Math.max(localMax, globalMax);
		}
		
		return globalMax;
    }

}
