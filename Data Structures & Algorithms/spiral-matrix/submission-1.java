class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int TOTAL = matrix.length * matrix[0].length;
        int up = matrix.length - 2, down = matrix.length - 1;
        int right = matrix[0].length, left = matrix[0].length - 1;
        int r = 0, c = -1;
        List<Integer> list = new ArrayList<>();
        while(list.size() < TOTAL){
            for(int i = 0; i < right && list.size() < TOTAL; i++){
                c++;
                list.add(matrix[r][c]);
            }
            right -= 2;
            for(int j = 0; j < down && list.size() < TOTAL; j++){
                r++;
                list.add(matrix[r][c]);
            }
            down -= 2;
            for(int i = 0; i < left && list.size() < TOTAL; i++){
                c--;
                list.add(matrix[r][c]);
            }
            left -= 2;
            for(int i = 0; i < up && list.size() < TOTAL; i++){
                r--;
                list.add(matrix[r][c]);
            }
            up -= 2;
        }
        return list;
    }
}