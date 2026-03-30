class Solution {
    boolean[][] visited;
    char[][] matrix;
    public void solve(char[][] board) {
        matrix = board;
        visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 'O') dfs(0,i);
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[matrix.length-1][i] == 'O') dfs(matrix.length-1,i);
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 'O') dfs(i,0);
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][matrix[0].length-1] == 'O') dfs(i,matrix[0].length-1);
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(!visited[i][j] && matrix[i][j] != 'X') matrix[i][j] = 'X';
            }
        }

    }

    private void dfs(int i, int j){
        if(!isValid(i,j) || matrix[i][j] == 'X' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }

    private boolean isValid(int i, int j){
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}