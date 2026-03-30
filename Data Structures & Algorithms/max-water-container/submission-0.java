class Solution {
    public int maxArea(int[] heights) {
        int maxVol = 0;
        for(int i = 0; i < heights.length; i++){
            for(int j = i+1; j < heights.length;j++){
                int vol = Math.min(heights[i],heights[j])* (j-i);
                if(vol > maxVol){
                    maxVol = vol;
                }
            }
        }
        return maxVol;
    }
}
