import java.util.*;
public class sortPpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String[] sortPeople(String[] names, int[] heights) {
		int n = names.length;
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
        String[] ans = new String[n];
        for(int i = 0; i < n; i++) {
        	String name = names[i];
        	int height = heights[i];
        	tm.put(height, name);
        	
        }
        int index = 0;
        for(int e: tm.keySet()) {
        	ans[n - 1 - index] = tm.get(e);
        	index++;
        }
        return ans;
    }
}
