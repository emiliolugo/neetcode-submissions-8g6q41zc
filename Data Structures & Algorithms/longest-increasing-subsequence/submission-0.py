class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        LIS = [1] * n

        for i in range(n):
            LIS[i] = 1 + max((LIS[j] for j in range(i) if nums[j] < nums[i]), default = 0)
        return max(LIS)
        