class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, findArea(grid,i,j,0));
                }
            }
        }
        return maxArea;
    }
}

private int findArea(int[][] grid, int r, int c, int area){
    if(!isValid(grid,r,c)){
        return 0;}
    if(grid[r][c]==1){
        grid[r][c] = 0;
        area++;
        area += findArea(grid,r+1,c,0);
        area += findArea(grid,r-1,c,0);
        area += findArea(grid,r,c+1,0);
        area += findArea(grid,r,c-1,0);
    }

    return area;
}

private boolean isValid(int[][] grid, int r, int c){
    return r >= 0 && r < grid.length && c >=0 && c < grid[0].length;
}
