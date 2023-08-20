import java.util.*;
public class minGarbageCollect {

	public static void main(String[] args) {
		String[] garbage = {"G","P","GP","GG"};
		int[] travel = {2,4,3};
		int res = garbageCollection(garbage, travel);
		System.out.println(res);
	}
	
	public static int garbageCollection(String[] garbage, int[] travel) {
        int lastGlass = -1;
		int lastMetal = -1;
		int lastPlastic = -1;
		int glass = 0;
		int metal = 0;
		int plastic = 0;
        for(int i = 0; i < garbage.length; i++) {
        	int[] g = countChars(garbage[i]);
        	if(g[0] != 0) {
        		glass+= g[0];
        		lastGlass = i;
        	}
        	if(g[1] != 0) {
        		metal += g[1];
        		lastMetal = i;
        	}
        	if(g[2] != 0) {
        		plastic += g[2];
        		lastPlastic = i;
        	}
        }
        int res = 0;
        for(int i = 0; i < lastGlass; i++) {
        	res += travel[i];
        }
        for(int i = 0; i < lastPlastic; i++) {
        	res += travel[i];
        }

        for(int i = 0; i < lastMetal; i++) {
        	res += travel[i];
        }
        res += (glass + metal + plastic);
        return res;
    }
	
	public static int[] countChars(String s) {
		int[] res = new int[3];
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'G') {
				res[0] ++;
			}else if (s.charAt(i) == 'M') {
				res[1] ++;
			}else {
				res[2]++;
			}
		}
		return res;
	}
	
}
