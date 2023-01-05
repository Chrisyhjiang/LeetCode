
public class meetingRoomsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minMeetingRooms(int[][] intervals) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length; i++) {
        	max = Math.max(max, intervals[i][1]);
        }
        int[] psa = new int[max + 1];
        for(int i = 0; i < intervals.length; i++) {
        	psa[intervals[i][0]]++;
        	psa[intervals[i][1]]--;
        }
        max = 0;
        for(int i = 0; i < psa.length; i++) {
        	psa[i] = psa[i-1] + psa[i];
        	max = Math.max(max, psa[i]);
        }
        return max;
    }

}
