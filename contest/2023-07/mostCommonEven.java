import java.util.*;
public class mostCommonEven {

	public static void main(String[] args) {
		int[] arr = {29,47,21,41,13,37,25,7};
		int res = mostFrequentEven(arr);
		System.out.println(res);
	}
	
	public static int mostFrequentEven(int[] nums) {
		int[] arr = new int[100003];
		Arrays.fill(arr, -1);
		for(int i = 0; i < nums.length; i++) {
			arr[nums[i]]++;
		}
		int maxIndex = -1;
		int max = -1;
		for(int i = 0; i < arr.length; i++) {
			if(i % 2 == 0) {
				if(arr[i] > max) {
					maxIndex = i;
					max = arr[i];
				}else if(arr[i] == max){
					maxIndex = Math.min(i, maxIndex);
				}
			}
		}
		return maxIndex;
    }

}
