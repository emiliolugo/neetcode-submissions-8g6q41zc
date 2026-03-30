class Solution {
    public int trap(int[] height) {
        int r = height.length-1, l = 0;
        int maxR = 0, maxL = 0;
        int total = 0;
        while(l<r){
            maxL = Math.max(height[l],maxL);
            maxR = Math.max(height[r],maxR);

            if(maxL <= maxR){
                l++;
                total+= Math.max(0,maxL-height[l]);
            }
            else{
                r--;
                total+= Math.max(0,maxR-height[r]);
            }
        }
        return total;
    }
}
