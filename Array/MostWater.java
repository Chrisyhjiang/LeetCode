package LeetCode.Array;

public class MostWater {
	public static int maxArea(int[] height) {
		int max = 0;
		
		for (int i = 0; i < height.length-1; i++) {
			for (int j = i+1; j < height.length; j++) {
				int min = Math.min(height[i], height[j]);
				int area = min * (j-i);
				max = Math.max(area, max);
			}
		}
		return max;
	}
	public static int maxArea2(int[] height) {
		// uses the double pointer method with pointer shifting. 
		int max = 0;
		int left = 0; int right = height.length-1;
		while (right > left) {
			int min = Math.min(height[right], height[left]);
			max = Math.max(max, min * (right - left));
			
			if (height[left] < height[right]) {
				left++;
			}else {
				right--;
			}
			
		}
		
		return max;
	}
	public static void main(String[] args) {
		int[] heights = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea2(heights));
		
	}
}
