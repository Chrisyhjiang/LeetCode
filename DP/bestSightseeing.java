// https://leetcode.com/problems/best-sightseeing-pair/
public class bestSightseeing {

	public static void main(String[] args) {
		int[] values = {8,1,5,2,6};
		int res = maxScoreSightseeingPair(values);
		System.out.println(res);
	}
	
	public static int maxScoreSightseeingPair(int[] values) {
		int maxLeftIndex = -1;
        int maxLeftVal = Integer.MIN_VALUE;
        int maxTotalVal = Integer.MIN_VALUE;
        for(int i = 1; i < values.length; i++) {
        	// get the max left
        	int curLeft = values[i - 1] + i - 1;
        	if(curLeft > maxLeftVal) {
        		maxLeftIndex = i - 1;
        		maxLeftVal = curLeft;
        	}
        	int curMax = values[i] + maxLeftVal - i;
        	maxTotalVal = Math.max(maxTotalVal, curMax);
        	
        }
        return maxTotalVal;
        
    }
}
