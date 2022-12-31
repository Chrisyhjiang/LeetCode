import java.util.*;
public class rotateArr {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		rotate(arr, 3);
	}
	
	public static void rotate(int[] nums, int k) {
		int[] temp = nums.clone();
		int n = nums.length;
		k %= n;
		for(int i = 0; i < nums.length; i++) {
			nums[i] = temp[(i + n - k) % n];
		}
    }
}
