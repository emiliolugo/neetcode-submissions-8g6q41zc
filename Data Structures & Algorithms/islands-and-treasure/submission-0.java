class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==0){
                    findDistances(i,j,grid,0);
                }
            }
        }
    }

    private void findDistances(int r, int c, int[][] grid, int distance){
        if(grid[r][c] == -1){
            return;
        }

        grid[r][c] = distance;
        distance++;
        if(isValid(r-1,c,grid) && distance < grid[r-1][c]){
            findDistances(r-1,c,grid,distance);
        }
        if(isValid(r+1,c,grid) && distance < grid[r+1][c]){
            findDistances(r+1,c,grid,distance);
        }
        if(isValid(r,c+1,grid) && distance < grid[r][c+1]){
            findDistances(r,c+1,grid,distance);
        }
        if(isValid(r,c-1,grid) && distance < grid[r][c-1]){
            findDistances(r,c-1,grid,distance);
        }
        
    }

    private boolean isValid(int r, int c, int[][] grid){
        return r < grid.length && r >= 0 && c < grid[0].length && c >= 0;
    }
}
