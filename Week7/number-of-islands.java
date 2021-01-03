class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[i].length;j++){
                if (grid[i][j] == '1'){
                    num++;
                    findIsland(grid,i,j);
                }
            }
        }
        return num;
    }

    public void findIsland(char[][] grid, int i, int j){
        int bottom = grid.length;
        int right = grid[0].length;
        if (i<bottom && j<right && i>=0 && j>=0 && grid[i][j] == '1' ){
            grid[i][j] = 0;
            findIsland(grid, i+1, j);
            findIsland(grid, i, j+1);
            findIsland(grid, i-1, j);
            findIsland(grid, i, j-1);
        }
        return;
    }
}
