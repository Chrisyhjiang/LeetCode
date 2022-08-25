import java.util.*;
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1,2,0,3,2,5};
		int ans = trap2(height);
		System.out.println(ans);
	}
	
	public static int trap(int[] height) {
		if(height.length == 1 || height.length == 2) {
			return 0;
		}else {
			int len = height.length;
			int[] maxLeft = new int[len];
			int[] maxRight = new int[len];
			int l = Integer.MIN_VALUE;
			int r = Integer.MIN_VALUE;
			for(int i = 0; i < len; i++) {
				if(height[i] > l) {
					maxLeft[i] = height[i];
					l = height[i];
				}else {
					maxLeft[i] = maxLeft[i-1];
				}
				if(height[len - 1 - i] > r) {
					maxRight[len - 1 - i] = height[len - 1 - i];
					r = height[len - 1 - i];
				}else {
					maxRight[len - 1 - i] = maxRight[len - i];
				}
			}
			int total = 0;
			for(int i = 0; i < len; i++) {
				int val =  Math.min(maxLeft[i], maxRight[i]) - height[i];
				if(val > 0) {
					total += val;
				}
			}
			return total;
 		} 
    }
	public static int trap2(int[] height) {
		int left = 0;
		int right = 1;
		int res = 0;
		int cur = 0;
		int level = height[0];
		while(right< height.length) {
			if(height[right] > level) {
				res += cur;
				level = height[right];
				cur = 0;
				left = right;
			}else {
				cur += Math.max(level - height[right],0);
			}
			right++;
		}
		
		return res;
	}
}
