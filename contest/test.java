import java.util.*;
class test {
  private static final int modulo = (int) 1e9 + 7;

  public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
    Set<Integer> hs = new HashSet<>();
    List<Integer> ls = new ArrayList<>();
    for (int x: hFences) {
        ls.add(x);
    }
    ls.add(1);
    ls.add(m);

    for (int i = 0; i < ls.size(); i++) {
      for (int j = 0; j < ls.size(); j++) {
        hs.add(Math.abs(ls.get(j) - ls.get(i)));
      }
    }


    List<Integer> ls2 = new ArrayList<>();
    for (int x: vFences) {
        ls2.add(x);
    }
    ls2.add(1);
    ls2.add(n);

    int side = 0;
    // check vertical fences
    for (int i = 0; i < ls2.size(); i++) {
      for (int j = i + 1; j < ls2.size(); j++) {
        int distance = Math.abs(ls2.get(j) - ls2.get(i));
        if (hs.contains(distance)) {
          side = Math.max(side, distance);
        }
      }
    }

    if (side == 0) {
      return -1;
    }

    return (int) ((long) side * side % modulo);
  }
  
  public static void main(String[] args) {
	  int m = 4;
	  int n = 3;
	  int[] x = {2, 3};
	  int[] y = {2};
	  
	  int res = maximizeSquareArea(m, n, x, y);
	  System.out.println(res);
  }
}