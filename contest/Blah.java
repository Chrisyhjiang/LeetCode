import java.util.*;
public class Blah {
	public static class Pair {
        int k;
        int v;
        public Pair(int a, int b) {
            k = a;
            v = b;
        }
    }

    public static long beautifulSubstrings(String s, int k) {
        int d = 1;
        while(true) {
            if ((d * d % (4 * k)) == 0) {
                k = d;
                break;
            }
            d++;
        }

        int[] psa = new int[s.length() + 1];
        psa[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            psa[i] = psa[i - 1] + (isVowel(s.charAt(i - 1)) ? 1 : -1);
        }
        long res = 0;
        HashMap<Pair, Long> hm = new HashMap<>();
        for (int i = 0; i < psa.length; i++) {
            int sum = psa[i];
            Pair p = new Pair(i % k, sum);
            if (hm.containsKey(p)) {
                res += hm.get(p);
            }
            hm.put(p, hm.getOrDefault(p,0L) + 1);
        }
        return res;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    
	public static void main(String[] args) {
		long res = beautifulSubstrings("baeyh", 2);

	}

}
