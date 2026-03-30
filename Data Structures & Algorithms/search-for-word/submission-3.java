class Solution {
    boolean[][] visited;
    char[][] ourB;
    public boolean exist(char[][] board, String word) {
       visited = new boolean[board.length][board[0].length];
       ourB = board;
        for(int i = 0; i < ourB.length; i++){
            for(int j = 0; j < ourB[0].length;j++){
                if(ourB[i][j]==word.charAt(0)){
                    if(helper(word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(!isValid(i,j) || visited[i][j]==true || word.charAt(index)!=ourB[i][j]){
            return false;
        }
        
        visited[i][j] = true;

        boolean found = helper(word, i+1, j, index+1) 
            || helper(word, i-1, j, index+1) 
            || helper(word, i, j+1, index+1)
            || helper(word, i, j-1, index+1);

        visited[i][j] = false;

        return found;
    }

    private boolean isValid(int i, int j){
        return i < ourB.length && i >= 0 && j>=0 && j < ourB[0].length;
    }
}
