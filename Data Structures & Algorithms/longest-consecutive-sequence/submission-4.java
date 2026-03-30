class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int l = 0; int r = 0;
        int curr = nums[0];
        int currStreak = 1;
        int maxStreak = 1;
        while(l<=r && r < nums.length-1){
            r++;
            if(curr == nums[r] -1){
                currStreak++;
                maxStreak = Math.max(currStreak,maxStreak);
            }
            else if(curr == nums[r]) continue;
            else{
                currStreak = 1;
                l = r;
            }
            curr = nums[r];
        }

        return maxStreak;
        
    }
}
