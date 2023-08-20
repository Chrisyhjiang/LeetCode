// https://leetcode.com/contest/weekly-contest-325/problems/shortest-distance-to-target-string-in-a-circular-array/
public class shortestCircularStrDist {

	public static void main(String[] args) {
		System.out.println((-1 + 5) % 5);

	}
	
	public boolean contains(String target, String[] words) {
		for(String s: words) {
			if (s.equals(target)){
				return true;
			}
		}
		return false;
	}
	
	public int closetTarget(String[] words, String target, int startIndex) {
		int res = 0;
		int n = words.length;
		if(n == 1 || n == 2) {
			res =  n - 1;
		}else {
			int i = startIndex;
			int j = startIndex;
			if(! contains(target, words)) {
				return -1;
			}
			while(i >= 0 && !words[i].equals(target) && j < n && !words[j].equals(target)) {
				i = (i - 1 + n) % n;
				j = (j + 1) % n;
				res++;
			}
		}
		return res;
    }

}
