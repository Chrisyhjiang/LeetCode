import java.util.*;
public class arithmeticSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int n: nums) {
        	hs.add(n);
        }
        for(int i = 0; i < nums.length; i++) {
        	boolean n1 = hs.contains(nums[i] + diff);
        	boolean n2 = hs.contains(nums[i] + 2 * diff);
        	if (n1 && n2) {
        		count++;
        	}
        }
        
        return count;
    }
}
