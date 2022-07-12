// https://leetcode.com/problems/rotate-image/
public class RotateImage {

	public static void main(String[] args) {
		int[][] mat = {{5,1,9,11},{2,4,8,10},{13,3,6,7}, {15,14,12,16}};
		rotate(mat);
		for(int[] a: mat) {
			for(int b: a) {
				System.out.println(b);
			}
		}
	}
	public static void rotate2(int[][] matrix) {
		int size = matrix.length;
		int[][] res = new int[size][size];
		int x = 0;
		int y = 0;
		for(int i = size - 1; i >= 0; i--) {
			for(int j = 0; j < size; j++) {
				int e = matrix[i][j];
				res[x][y] = e;
				y++;
			}
			y = 0; 
			x++;
		}
		matrix = res;
    }
	public static void rotate(int[][] matrix) {
		// rotate 4 each time: top left top right bottom right bottom left
		int size = matrix.length;
		for(int i = 0; i < size + 1 / 2; i++) {
			// i means how many layers there are;
			// get a loop to switch the layers.
			for(int j = i; j < size / 2; j++) {
				int tl = matrix[i][j];
				int tr = matrix[size - 1 - i][size - j - 1];
				int bl = matrix[size - 1 - j][i];
				int br = matrix[j][size - 1 -i];
				
                matrix[size - 1 - j][i] = tr;
                matrix[size - 1 - i][size - j - 1] = br;
                matrix[j][size - 1 - i] = tl;
                matrix[i][j] = bl;
			}
		}
    }
}
