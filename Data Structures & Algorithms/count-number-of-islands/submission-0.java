class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i = 0; i< grid.length; i++ ){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    counter++;
                    discoverIsland(i,j,grid);
                }
            }
        }
        return counter;
    }

    private void discoverIsland(int r, int c, char[][] grid){
        if(!isValid(r,c,grid)){
            return;
        }
        if(grid[r][c]=='1'){
            grid[r][c] = '0';
            discoverIsland(r-1,c,grid);
            discoverIsland(r+1,c,grid);
            discoverIsland(r,c-1,grid);
            discoverIsland(r,c+1,grid);
        }

        

    }

    private boolean isValid(int r, int c, char[][] grid){
        return r < grid.length && r >= 0 && c < grid[0].length && c >= 0;
    }
}
