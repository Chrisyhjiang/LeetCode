import java.util.HashSet;

public class validSudoku {

	public static void main(String[] args) {
		char[][] mat = {{'.','.','.','.','5','.','.','1','.'},
						{'.','4','.','3','.','.','.','.','.'},
						{'.','.','.','.','.','3','.','.','1'},
						{'8','.','.','.','.','.','.','2','.'},
						{'.','.','2','.','7','.','.','.','.'},
						{'.','1','5','.','.','.','.','.','.'},
						{'.','.','.','.','.','2','.','.','.'},
						{'.','2','.','9','.','.','.','1','.'},
						{'.','.','4','.','.','.','.','1','.'}};
						 
		boolean res = isValidSudoku(mat);
		System.out.println(res);
	}
	public static boolean isValidSudoku(char[][] board) {
		HashSet<Character> hs = new HashSet<Character>();
		boolean res = true;
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		if(board[i][j] != '.') {
					if(hs.contains(board[i][j])) {
						res = false;
						break;
					}
					hs.add(board[i][j]);
				}
        	}
        	hs.clear();
        }
        hs.clear();
		if(res) {
			for(int i = 0; i < 9; i++) {
	        	for(int j = 0; j < 9; j++) {
	        		if(board[j][i] != '.') {
						if(hs.contains(board[j][i])) {
							res = false;
							break;
						}
						hs.add(board[j][i]);
					}
	        	}
	        	hs.clear();
	        }
		}
		hs.clear();
		if(res){
			res = checkSquare(board);
		}
		
		return res;
    }
	public static boolean checkSquare(char[][] mat) {
		HashSet<Character> hs = new HashSet<Character>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 0; i < 3; i++) {
			for(int j = 3; j < 6; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 0; i < 3; i++) {
			for(int j = 6; j < 9; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 3; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 3; i < 6; i++) {
			for(int j = 3; j < 6; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 3; i < 6; i++) {
			for(int j = 6; j < 9; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 6; i < 9; i++) {
			for(int j = 0; j < 3; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 6; i < 9; i++) {
			for(int j = 3; j < 6; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		hs.clear();
		for(int i = 6; i < 9; i++) {
			for(int j = 6; j < 9; j++) {
				if(mat[i][j] != '.') {
					if(hs.contains(mat[i][j])) {
						return false;
					}
					hs.add(mat[i][j]);
				}
			}
		}
		return true;
	}
}
