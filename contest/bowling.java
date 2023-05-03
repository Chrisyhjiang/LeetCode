
public class bowling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int isWinner(int[] player1, int[] player2) {
		int n = player1.length;
		if (n == 0) {
			return 0;
		}
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < n; i++) {
			if (i == 0) {
				sum1 += player1[i];
				sum2 += player2[i];
			} else if (i == 1) {
				if (player1[i-1] == 10) {
					sum1 += 2 * player1[i]; 
				}else {
					sum1 += player1[i];
				}
				if (player2[i-1] == 10) {
					sum2 += 2 * player2[i]; 
				}else {
					sum2 += player2[i];
				}
				
			} else {
				if (player1[i-1] == 10 || player1[i-2] == 10) {
					sum1 += 2 * player1[i]; 
				}else {
					sum1 += player1[i];
				}
				if (player2[i-1] == 10 || player2[i-2] == 10) {
					sum2 += 2 * player2[i]; 
				}else {
					sum2 += player2[i];
				}
			}
			
		}
		if (sum1 > sum2) {
			return 1;
		}else if (sum1 < sum2) {
			return 2;
		}else {
			return 0;
		}
		
    }

}
