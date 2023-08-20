import java.util.*;
public class robotPrint {

	public static void main(String[] args) {
		String res = robotWithString("bdda");
		System.out.println(res);
	}
	public static String robotWithString(String s) {
		int n = s.length();
		Stack<Character> robot = new Stack<Character>();
		StringBuilder res = new StringBuilder();
		// denotes the minimum char from that point of Index and forward. 
		char[] minChar = new char[n];
		char curMin = s.charAt(n-1);
		minChar[n-1] = curMin;
		
		// using PSA to store and gain access to the smallest char at ith index. 
		for(int i = n - 2; i>= 0; i--) {
			minChar[i] = (char) Math.min(minChar[i+1], s.charAt(i));
		}
		int sIndex = 0;
		
		while(sIndex < n) {
			// if the robot stack is empty push a charater in and do nothing else
			if(robot.isEmpty()) {
				robot.push(s.charAt(sIndex));
				sIndex++;
				continue;
			}else {
				if(minChar[sIndex] < robot.peek()) {
					char req = minChar[sIndex];
					// pop until minChar is reached. 
					while(s.charAt(sIndex) != req) {
						robot.push(s.charAt(sIndex));
						sIndex++;
					}
					// push the least element into the robot. 
					robot.push(s.charAt(sIndex));
					sIndex++;
				}
				// this will always be the smallest lexigraphically possible element. 
				res.append(robot.pop());
			}
		}
		while(!robot.isEmpty()) {
			res.append(robot.pop());
		}
		return res.toString();
    } 
	
}
