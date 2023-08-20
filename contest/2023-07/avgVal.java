
public class avgVal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int averageValue(int[] nums) {
		int res = 0;
		int count = 0;
		for(int e: nums) {
			if(e % 6 == 0) {
				res += e;
				count++;
			}
		}
		
		if(count != 0) {
			return res/count;
		}else {
			return 0;
		}
		
    }
}
