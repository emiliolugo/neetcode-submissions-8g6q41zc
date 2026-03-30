class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int currSum = 0;
        for(int r = 0;r < nums.length;r++){
            currSum += nums[r];

            while(currSum >= target && l<=r){
                if(currSum >= target) min = Math.min(r-l+1,min);
                currSum -= nums[l];
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? 0: min;
    }
}