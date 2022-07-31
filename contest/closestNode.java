import java.util.*;
public class closestNode {
	
	public static void main(String[] args) {
		int[] edge = {2,2,3,-1};
		int n1 = 0;
		int n2 = 1;
		int res = closestMeetingNode(edge, n1, n2);
		System.out.println(res);
	}
	public static int closestMeetingNode(int[] edges, int node1, int node2) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> n1 = dfs(edges, node1, hm, 0);
        
        HashMap<Integer, Integer> n2 = dfs(edges, node2, hm2, 0);
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for(int k: n1.keySet()) {
        	if(n2.containsKey(k)) {
        		int current = Math.max(n1.get(k), n2.get(k));
        		if(current < minValue) {
        			minValue = current;
        			minIndex = k;
        		}else if (minValue == current) {
        			minIndex = Math.min(minIndex, k);
        		}
        	}
        }
        return minIndex;
    }
	
	public static HashMap<Integer, Integer> dfs(int[] edges, int node, HashMap<Integer, Integer> distances, int distance) {
		if(edges[node] == -1) {
			distances.put(node, distance);
			return distances;
		}else if(distances.containsKey(node)) {
			return distances;
		}else {
			distances.put(node, distance);
			distance++;
			return dfs(edges, edges[node], distances, distance);
		}
	}
}
