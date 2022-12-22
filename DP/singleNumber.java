
public class singleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int singleNumber(int[] nums) {
		// xor can be used to manipulate and check for duplicates. 
		// a xor a = 0
		// a xor 0 = a
		// a xor b xor a = a xor a xor b = 0 xor b = b; 
		int res = 0;
		for(int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
    }

}
