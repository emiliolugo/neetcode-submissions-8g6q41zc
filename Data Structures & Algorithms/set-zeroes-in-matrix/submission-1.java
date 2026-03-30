class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[][] turnZero = new boolean[matrix.length][matrix[0].length];

        for(boolean[] b: turnZero){
            Arrays.fill(b, false);
        }

        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(matrix[i][j]==0){
                    helper(turnZero, i, j, 0);
                }
            }
        }

        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(turnZero[i][j]){
                    matrix[i][j]=0;
                }
                
            }
        }
    }

    private void helper(boolean[][] turnZero, int i, int j, int d){
        if(!isValid(turnZero.length, turnZero[0].length, i,j)){
            return;
        }

        turnZero[i][j] = true;

        if(d == 1 || d==0){
            helper(turnZero,i-1,j, 1);
        }
        if(d == 2 || d==0){
            helper(turnZero,i+1,j, 2);
        }
        if( d==3 || d==0){
            helper(turnZero,i,j-1,3);
        }
        if(d==4 || d==0){
            helper(turnZero,i,j+1,4);
        }
        
        
        
    }

    private boolean isValid(int r, int c, int i, int j){
        return i < r && i >=0 && j < c && j >=0;
    }
}
