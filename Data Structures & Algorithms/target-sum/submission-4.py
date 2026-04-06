class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        s = sum(nums)
        if(abs(target) > s):
            return 0
        
        tracker = [[0 for _ in range(s*2+1)] for _ in range(len(nums))]

        tracker[0][s+nums[0]] += 1
        tracker[0][s-nums[0]] += 1
        for i in range(len(nums)-1):
            for j in range(len(tracker[0])):
                if tracker[i][j] == 0:
                    continue
                if j - nums[i+1] >= 0 and j - nums[i+1] < len(tracker[0]):
                    tracker[i+1][j-nums[i+1]] += tracker[i][j]
                if j + nums[i+1] >= 0 and j + nums[i+1] < len(tracker[0]):
                    tracker[i+1][j+nums[i+1]] += tracker[i][j]
        
        return tracker[-1][s+target]



        