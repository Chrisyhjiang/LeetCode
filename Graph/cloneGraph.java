// https://leetcode.com/problems/clone-graph/submissions/
import java.util.*;
public class cloneGraph {
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	public static void main(String[] args) {
		
	}
	public Node cloneGraph(Node node) {
		HashMap<Node, Node> visited = new HashMap<Node, Node>();
		Node cloned = traverse(node,visited);
		return cloned;		
    }
	
	public static Node traverse(Node cur, HashMap<Node,Node> visited) {
		if(visited.containsKey(cur)) {
			return visited.get(cur);
		}else {
			Node cloned = new Node(cur.val, new ArrayList<Node>());
			visited.put(cur, cloned);
			for(Node n: cur.neighbors) {
				cloned.neighbors.add(traverse(n, visited));
			}
			return cloned;
		}
	}
}
