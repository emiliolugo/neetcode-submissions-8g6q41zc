class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        curr_max = nums[0]
        curr_min = nums[0]
        global_max = nums[0]
        n = len(nums)

        for i in range(1,n):
            prev_max = curr_max
            prev_min = curr_min
            curr_max = max(prev_max * nums[i], prev_min * nums[i],nums[i])
            curr_min = min(prev_max * nums[i], prev_min * nums[i],nums[i])
            global_max = max(global_max,curr_max)

        return global_max
        