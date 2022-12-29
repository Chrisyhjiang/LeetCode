// https://leetcode.com/problems/min-stack/
import java.util.*;
public class MinStack {
	Stack<int[]> st; 
	Integer min = null;
	public MinStack() {
		st = new Stack<int[]>();
    }
    
    public void push(int val) {
    	if (st.isEmpty()) {
            st.push(new int[]{val, val});
            return;
        }
        
        int currentMin = st.peek()[1];
        st.push(new int[]{val, Math.min(val, currentMin)});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
    	return st.peek()[1];
    }

}
