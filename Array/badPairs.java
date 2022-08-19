import java.util.*;
public class badPairs {

	public static void main(String[] args) {
		int[] nums = {4,1,3,3};
		long res = countBadPairs(nums);
		System.out.println(res);
	}
	public static long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
        	int key = nums[i] - i;
        	if(hm.containsKey(key)) {
        		hm.put(key,hm.get(key)+1);
        	}else {
        		hm.put(key, 1);
        	}
        }
        long res = 0;
        for(int i = 0; i < nums.length; i++) {
        	res += nums.length - 1 - i;
        	if(hm.containsKey(nums[i] - i)) {
        		res -= hm.get(nums[i] - i) - 1;
        		hm.put(nums[i]-i, hm.get(nums[i]-i) - 1);
        	}
        }
        return res;
    }
}
