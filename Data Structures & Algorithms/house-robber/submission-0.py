class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1, rob2 = 0,0

        for house in nums:
            curr = max(rob1+house,rob2)
            rob1 = rob2
            rob2 = curr
        return max(rob1,rob2)