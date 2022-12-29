// https://leetcode.com/problems/k-closest-points-to-origin/
// max heap
import java.util.*;
public class kclosestOrigin {
	public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> distance(p2) - distance(p1));
        for (int[] p : points) {
            if (pq.size() < K)
                pq.offer(p);
            else if (distance(pq.peek()) > distance(p)) {
                    pq.poll();
                    pq.offer(p);
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++)
            res[i] = pq.poll();
        return res;
    }
    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
