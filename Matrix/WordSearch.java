// https://leetcode.com/problems/word-search/
import java.util.Arrays;

public class WordSearch {

	public static void main(String[] args) {
		String target = "ABCB";
		char[][] myBoard = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		boolean res = exist(myBoard, target);
		System.out.println(res);
		
	}
	static boolean[][] visited;
    static char[][] myBoard;
    static String myWord;
    // search for all available heads
    public static boolean exist(char[][] board, String word) {
		int n = board.length;
        int k = board[0].length;
        if(word.length() > n * k) {
        	return false;
        }
        boolean res = false;
		char c = word.charAt(0);
        visited = new boolean[n][k];
        myBoard = board;
        myWord = word;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				char head = myBoard[i][j];
				if(head == c) {
					res = DFS(i , j, 0);
                    if(res){
                        return true;
                    }
				}
			}
		}
		return false;
    }
    // i and j are the positions in the matrices k is used to check the base case.
    public static boolean DFS(int i, int j, int k) {
		boolean res = false;
		if(inRangeNotVisited(i, j)) {
			if(k == myWord.length()) {
				res = true;
			}else {
				char target = myWord.charAt(k);
				if(myBoard[i][j] == target) {
					visited[i][j] = true;
					// call four left right up down
                    if(k + 1 < myWord.length()){
                      if(DFS(i -1, j, k + 1)) {
						return true;
                      }else if(DFS(i + 1, j, k + 1)) {
						return true;
                      }else if(DFS(i, j - 1, k + 1)) {
						return true;
                      }else if(DFS(i, j + 1, k + 1)) {
						return true;
                      }
                        // all four cases fail
                      visited[i][j] = false;  
                    }else{
                        res = true;
                    }
				}
			}
		}
		return res;
	}
	// check if the particular cell is in range or visited. 
	public static boolean inRangeNotVisited(int i, int j) {
		return (i >= 0 && i < myBoard.length) &&  
				(j >= 0 && j < myBoard[0].length) &&
				(!visited[i][j]);
	}
	
}
