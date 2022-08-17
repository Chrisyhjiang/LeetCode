// https://leetcode.com/problems/gas-station/
import java.util.*;
public class gasStation {

	public static void main(String[] args) {
		int[] gas = {6,1,4,3,5};
		int[] cost = {3,8,2,4,2};
		int res = canCompleteCircuit(gas, cost);
		System.out.println(res);
	}
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
		int len = gas.length;
		int[] diff = new int[len];
		for(int i = 0; i < len; i++) {
			diff[i] = gas[i] - cost[i];
			total += diff[i];
		}
		if(total < 0) {
			return -1;
		}else {
			int largestIndex = 0;
			int largest = diff[0];
			for(int i = 1; i < diff.length; i++) {
				if(largest < 0) {
					if(diff[i] < 0) {
						// do nothing
						continue;
					}else {
						largestIndex = i;
						largest = diff[i];
					}
				}else {
					if(diff[i] < 0) {
						largest += diff[i];
					}else {
						largest += diff[i];
					}
				}
			}
			return largestIndex;
		}
    }
}
