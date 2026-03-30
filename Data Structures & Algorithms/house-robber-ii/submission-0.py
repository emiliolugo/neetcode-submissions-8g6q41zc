class Solution:
    def rob(self, nums: List[int]) -> int:
        self.nums = nums
        n = len(nums)
        if n == 1:
            return nums[0]
        return max(self.rob_helper(0,n-1), self.rob_helper(1,n))
    
    def rob_helper(self, start: int, end: int):

        rob1, rob2 = 0,0
        for i in range(start, end):
            curr = max(rob1+self.nums[i],rob2)
            rob1 = rob2
            rob2 = curr
        return max(rob1,rob2)

        
        