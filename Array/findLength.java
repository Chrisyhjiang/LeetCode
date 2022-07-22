
public class findLength {

	public static void main(String[] args) {
		int[] n = {1,2};
		int ans = getLength(n);
		System.out.println(ans);
	}
	public static int getLength(int[] nums) {
		int i = 0;
		while(true) {
			try {
				int j = nums[i];
				i++;
			}catch (Exception e){
				break;
			}
		}
		return i;
	}
}
