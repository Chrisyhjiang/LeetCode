// https://leetcode.com/problems/course-schedule/description/
import java.util.*;
public class courseSchedule {
	static boolean[] visited;
	static boolean[] checked;
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{1,0}, {0,1}};
		boolean b = canFinish(numCourses, prerequisites);
		System.out.println(b);
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		visited = new boolean[numCourses];
		checked = new boolean[numCourses];
		ArrayList<Integer>[] graph = new ArrayList[numCourses];
		for(int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int[] arr: prerequisites) {
			graph[arr[0]].add(arr[1]);
		}
		for(int i = 0; i < numCourses; i++) {
			// if the node is checked, there is no need to check it again. 
			if (checked[i]) {
				continue;
			}
			boolean b = cyclic(graph, i);
			if(b) {
				return false;
			}
			// only the visited array has to be reset. 
			visited = new boolean[numCourses];
		}
		
		return true;
    }

	public static boolean cyclic(ArrayList<Integer>[] graph, int node) {
		// if the node is checked, we dont need to check
		if (checked[node]) {
			return false;
		}
		// if its not checked and visited, then there is a cycle 
		if(visited[node]) {
			return true;
		} else {
			visited[node] = true;
			for(int i = 0; i < graph[node].size(); i++) {
				if(cyclic(graph, graph[node].get(i))) {
					return true;
				}
			}
			checked[node] = true;
			return false;
		}
	}


}
