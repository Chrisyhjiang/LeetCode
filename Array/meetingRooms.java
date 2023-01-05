// https://leetcode.com/problems/meeting-rooms/
public class meetingRooms {
	
	public static void main(String[] args) {
		
	}
	
	public boolean canAttendMeetings(int[][] intervals) {
		if(intervals.length == 1) {
			return true;
		}
		int len = (int) (1e4 + 1);
		int[] psa = new int[len];
		for(int i = 0; i < intervals.length; i++) {
			psa[intervals[i][0]]++;
			psa[intervals[i][1]]--;
		}
		
		for(int i = 1; i < psa.length; i++) {
			psa[i] = psa[i-1] + psa[i];
			if(psa[i] > 1) {
				return false;
			}
		}
		return true;
		
    }
}
