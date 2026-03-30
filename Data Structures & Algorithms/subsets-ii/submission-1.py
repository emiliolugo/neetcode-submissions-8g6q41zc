class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return []
        n = len(nums)
        nums.sort()
        ret = []
        def helper(curr: List[int], index: int):
            if index >= n:
                ret.append(curr[:])
                return
            
            curr.append(nums[index])
            helper(curr,index+1)
            curr.pop()

            while index + 1 < n and nums[index] == nums[index+1]:
                index+=1
            
            helper(curr,index + 1)

        helper([],0)
        return ret

            

        