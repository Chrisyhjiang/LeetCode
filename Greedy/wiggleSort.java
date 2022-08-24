
public class wiggleSort {

	public static void main(String[] args) {
		

	}
	
	public void wiggleSort(int[] nums) {
		boolean bigger = true;
        for(int i = 1; i < nums.length; i++) {
        	if(bigger) {
        		if(nums[i] < nums[i-1]) {
        			int temp = nums[i-1];
        			nums[i-1] = nums[i];
        			nums[i] = temp;
        		} 
        		
        	}else {
        		if(nums[i] > nums[i-1]) {
        			int temp = nums[i-1];
        			nums[i-1] = nums[i];
        			nums[i] = temp;
        		} 
        	}
        	bigger = !bigger;
        }
    }

}
