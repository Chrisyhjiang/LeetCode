
public class subtract {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minimumOperations(int[] nums) {
		int count = 0;
		boolean[] arr = new boolean[103];
		for(int num: nums) {
			if(num != 0 && !arr[num]) {
				count++;
				arr[num] = true;
			}
		}
		return count;
    }

}
