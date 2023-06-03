class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        
        // 상하 반전
        for (int i=0; i<=n/2; i++) {
            int[] upper = matrix[i];
            int[] lower = matrix[n-i];
            
            // swap
            int[] temp = upper.clone();
            for (int j=0; j<upper.length; j++) {
                upper[j] = lower[j];
                lower[j] = temp[j];
            }
        }
        
        boolean[][] swapped = new boolean[n+1][n+1];
        
        // 대각선 반전
        for (int y=0; y<=n; y++) {
            for (int x=0; x<=n; x++) {
                if (y == x)
                    continue;
                
                if (swapped[y][x])
                    continue;
                
                int temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
                
                swapped[y][x] = true;
                swapped[x][y] = true;
            }
        }
    }
}