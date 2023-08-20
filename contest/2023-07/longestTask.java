import java.util.*;
public class longestTask {

	public static void main(String[] args) {
		int[][] mat = {{36,3},{1,5},{12,8},{25,9},{53,11},{29,12},{52,14}};
		int res = hardestWorker(70, mat);
		System.out.println(res);

	}
	
	public static int hardestWorker(int n, int[][] logs) {
		int maxTime = logs[0][1];
		int maxIndex = 0;
		
		for(int i = 1; i < logs.length; i++) {
			int curTime = logs[i][1] - logs[i-1][1];
			if(curTime > maxTime) {
				maxIndex = i;
				maxTime = curTime;
			}else if (curTime == maxTime) {
				if(logs[maxIndex][0] > logs[i][0]) {
					maxIndex = i;
				}
			}
		}
		return logs[maxIndex][0];
		
    }

}
