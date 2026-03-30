class Solution {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0], curr = 0;
        for(int n: nums){
            if(curr < 0){
                curr = 0;
            }
            curr += n;
            maxSub = Math.max(maxSub,curr);
        }

        return maxSub;
    }
}
