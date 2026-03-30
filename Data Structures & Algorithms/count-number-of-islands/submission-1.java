class Solution {
    char[][] balls;
    public int numIslands(char[][] grid) {
        balls = grid;
         

        int n = 0;
        for(int i = 0; i< balls.length; i++){
            for(int j = 0; j < balls[0].length;j++){
                if(balls[i][j]=='1'){
                    n++;
                  findIslands(i,j);  
                } 
            }
        }

        return n;
        
    }

    void findIslands(int i, int j){
            if(!isValid(i,j)) return;
            else if(balls[i][j] == '0') return;
            balls[i][j] = '0';
            findIslands(i+1,j);
            findIslands(i,j+1);
            findIslands(i-1,j);
            findIslands(i,j-1);
        }

        public boolean isValid(int i, int j){
            return i >= 0 && i < balls.length && j>=0 && j < balls[0].length;
        }


}
