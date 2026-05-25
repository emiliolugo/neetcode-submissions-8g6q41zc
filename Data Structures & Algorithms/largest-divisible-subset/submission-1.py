class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()

        dp = [[] for _ in range(len(nums))]
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] % nums[j] == 0 and len(dp[j]) > len(dp[i]):
                    dp[i] = dp[j][:]

            dp[i].append(nums[i])
        
        ret = []
        for ls in dp:
            if len(ls) > len(ret):
                ret = ls[:]
        return ret
                
                
        