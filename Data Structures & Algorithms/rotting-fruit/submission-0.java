class Solution {
    int n,m;
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int totalOranges = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i,j,0});
                if(grid[i][j] >= 1) totalOranges++;
            }
        }
        int minTime = 0;
        int orangesRotted = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            orangesRotted++;
            int i = current[0];
            int j = current[1];
            int time = current[2];
            minTime = Math.max(time,minTime);

            if(isValid(i+1,j) && grid[i+1][j] == 1){
                grid[i+1][j] = 2;
                queue.offer(new int[]{i+1,j,time+1});
            }
            if(isValid(i-1,j) && grid[i-1][j] == 1){
                grid[i-1][j] = 2;
                queue.offer(new int[]{i-1,j,time+1});
            }
            if(isValid(i,j+1) && grid[i][j+1] == 1){
                grid[i][j+1] = 2;
                queue.offer(new int[]{i,j+1,time+1});
            }
            if(isValid(i,j-1) && grid[i][j-1] == 1){
                grid[i][j-1] = 2;
                queue.offer(new int[]{i,j-1,time+1});
            }

        }

        if(totalOranges != orangesRotted) return -1;
        return minTime;
    }

    private boolean isValid(int i, int j){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}