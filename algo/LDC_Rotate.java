package algo;

public class LDC_Rotate {
    class Solution {
        public void rotate(int[][] matrix) {
            int[][] map = new int[matrix.length][matrix.length];

            for (int i=0; i<matrix.length; i++) {
                for (int j=0; j<matrix.length; j++) {
                    map[i][j] = matrix[matrix.length - 1 - j][i];
                }
            }

            for (int i=0; i<matrix.length; i++) {
                for (int j=0; j<matrix.length; j++) {
                    matrix[j][i] = map[j][i];
                }
            }
        }
    }
}
