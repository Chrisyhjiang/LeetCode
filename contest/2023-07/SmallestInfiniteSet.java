import java.util.*;

public class SmallestInfiniteSet {
	boolean[] arr;
	public SmallestInfiniteSet() {
         arr = new boolean[1000];
         Arrays.fill(arr, true);
    }
    
    public int popSmallest() {
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i]) {
        		arr[i] = false;
        		return i + 1;
        	}
        }
        return -1;
    }
    
    public void addBack(int num) {
        arr[num - 1] = true;
    }
}
