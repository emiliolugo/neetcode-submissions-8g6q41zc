class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0

        jumps = 0
        l = 0

        while l < len(nums):
            if l + nums[l] >= len(nums) -1:
                return jumps+1
            best_reach = -1
            best_idx = l
            for i in range(l + 1, l + nums[l] + 1):
                if i + nums[i] > best_reach:
                    best_reach = i + nums[i]
                    best_idx = i
            l = best_idx
            jumps+=1
                    
        return jumps
        