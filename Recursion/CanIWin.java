// https://leetcode.com/problems/can-i-win/submissions/
// #464
public class CanIWin {

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
		int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
		
		if (desiredTotal > sum) {
			return false;
		}
		
		if (desiredTotal <= 0) {
			return true;
		}
		
		byte[] states = new byte[1<<maxChoosableInteger]; // array of bytes containing each individual state, index is currentState
		
		return canIWin(maxChoosableInteger, desiredTotal, 0, states);
    }
	
	public boolean canIWin(int max, int desired, int currentState, byte[]states) {
		if (desired <= 0) {
			return false;
		}
		
		if (states[currentState] != 0) {
			return states[currentState] == 1; // checks cached value if it is win or not winnable. 
		}
		// state is 0, or it is has not been encountered
		
		for (int i = 0; i < max; i++) {
			if ((currentState & (1<< i)) == 0) {
				// checks if the state is used, use and to check if the above byte is 0. 
				int nextState = currentState | (1<<i);
				// next state has to update the numbers the next player chose use or to flip 0 to 1.
				if(!canIWin(max, desired - (i+1), nextState, states)) {
					states[currentState] = 1;
					return true;
				}
			}
		}
		states[currentState] = -1;
		
		return false;
	}

	public static void main(String[] args) {
		
		
	}

}
