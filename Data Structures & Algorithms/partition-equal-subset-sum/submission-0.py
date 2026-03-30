class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if(len(nums) == 0):
            return True
        sums = set()
        sums.add(nums[-1])
        sums.add(0)

        target = 0

        for n in nums:
            target+=n

        if target % 2 == 1:
            return False

        target /= 2

        for i in range(len(nums) - 2, -1, -1):
            iterable_sums = set(sums)
            for t in iterable_sums:
                if t == target:
                    return True
                if t + nums[i] == target:
                    return True
                sums.add(t+ nums[i])
        return False



        