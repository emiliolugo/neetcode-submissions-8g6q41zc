class Solution:
    def rob(self, nums: List[int]) -> int:
        def rob_help(start: int, end: int):
            rob1,rob2 = 0,0
            for i in range(start,end):
                curr = max(rob2, rob1+nums[i])
                rob1 = rob2
                rob2 = curr
            return max(rob1,rob2)
        n = len(nums)
        if len(nums) == 1:
            return nums[0]
        return max(rob_help(0,n-1), rob_help(1,n))
        