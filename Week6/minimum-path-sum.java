class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] shortest = new int[m][n];
        shortest[0][0] = grid[0][0];
        for (int i = 1;i<n;i++){
            shortest[0][i] = shortest[0][i-1]+grid[0][i]; 
        }
        for (int i = 1;i<m;i++){
            shortest[i][0] = shortest[i-1][0]+grid[i][0]; 
        }

        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                shortest[i][j] = Math.min(shortest[i][j-1],shortest[i-1][j])+grid[i][j];
            }
        }

        return shortest[m-1][n-1];
    }
}