class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int maxVol = 0;
        while(l < r){
            int h = Math.min(heights[l],heights[r]);
            int w = r-l;
            maxVol = Math.max(h*w, maxVol);
            if(heights[l]<heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxVol;
    }
}
