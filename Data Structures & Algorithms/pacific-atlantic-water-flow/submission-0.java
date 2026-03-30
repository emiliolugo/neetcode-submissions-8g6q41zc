class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        //top and bottom loop
        for(int i = 0; i < pacific[0].length;i++){
           dfs(pacific,0,i, heights); 
           dfs(atlantic,atlantic.length-1,i, heights); 
        } 

        //side loop
        for(int i = 0; i < pacific.length;i++){
           dfs(pacific,i,0, heights); 
            dfs(atlantic, i, atlantic[0].length-1, heights);
        } 

        List<List<Integer>> water = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]) water.add(List.of(i,j));
            }
        }
        
        return water;
    }

    private void dfs(boolean[][] grid, int r, int c, int[][] heights){
        if(grid[r][c] == true) return;

        grid[r][c] = true;
        if(isValid(r+1,c,heights) && heights[r][c] <= heights[r+1][c]) dfs(grid,r+1,c, heights); 
        if(isValid(r-1,c,heights) && heights[r][c] <= heights[r-1][c]) dfs(grid,r-1,c, heights); 
        if(isValid(r,c+1,heights) && heights[r][c] <= heights[r][c+1]) dfs(grid,r,c+1, heights); 
        if(isValid(r,c-1,heights) && heights[r][c] <= heights[r][c-1]) dfs(grid,r,c-1, heights); 
    }

    private boolean isValid(int r, int c, int[][] heights){
        return r >= 0 && r < heights.length && c >= 0 && c < heights[0].length;
    }

    
}
