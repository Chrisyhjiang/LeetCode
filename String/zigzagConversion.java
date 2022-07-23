// https://leetcode.com/problems/zigzag-conversion/
import java.util.*;
public class zigzagConversion {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
//		System.out.println(getLength(14,3));
		String res = convert(s, 9);
		System.out.println(res);
	}
	
	public static String convert(String s, int numRows) {
		if(numRows == 1) {
			return s;
		}
		StringBuilder sb  = new StringBuilder();
		int index = 2 - numRows;
		int length = getLength(s.length(), numRows);
		int count = 0;
		Character[][] mat = new Character[numRows][length];
		for(int i = 0; i < mat[0].length; i+= numRows - 1) {
			count++;
			index += numRows - 2;
			for(int j = 0; j < mat.length; j++) {
				if(index < s.length()) {
					mat[j][i] = s.charAt(index);
					index++;
				}else {
					break;
				}
				
			}
		}
		index = numRows;
		int i = numRows - 2;
		int j = 1;
		for(int a = 0; a < count; a++) {
			for(int b = 0; b < numRows - 2; b++) {
				if(index < s.length()) {
					mat[i][j] = s.charAt(index);
					index++;
					i--;
					j++;
				}
			}
			index += numRows;
			j += 1;
			i = numRows - 2;
		}
		
		for(int a = 0; a < mat.length; a++) {
			for(int b = 0; b < mat[0].length; b++) {
				if(mat[a][b] != null) {
					sb.append(mat[a][b]);
				}
			}
		}
		
		return sb.toString();
	}
	
	public static int getLength(int wordLength, int rows) {
		int res = 0;
		int m = wordLength * (rows-1) / (2 * rows - 2) ; 
		wordLength %= 2 * rows - 2;
		res += m + wordLength / rows + 1;
		
		return res;
	}
	
}
