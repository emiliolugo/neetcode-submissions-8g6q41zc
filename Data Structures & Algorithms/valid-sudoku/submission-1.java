class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();  
        List<Set<Character>> cols = new ArrayList<>();  
        List<Set<Character>> sub = new ArrayList<>(); 

        //populate lists
        for(int i = 0; i < board.length; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            sub.add(new HashSet<>());
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;

                int subIndex = (i / 3) * 3 + (j / 3);

                if(rows.get(i).contains(board[i][j])) return false;
                if(cols.get(j).contains(board[i][j])) return false;
                if(sub.get(subIndex).contains(board[i][j])) return false;
                
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                sub.get(subIndex).add(board[i][j]);
                }
        }

        return true;
    }
}
