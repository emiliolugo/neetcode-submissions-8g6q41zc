class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ret = []
        def helper(curr: List[int], s: int, i: int) -> None:
            if s == target:
                if curr in ret:
                    return
                ret.append(curr[:])
            if s > target or i == len(candidates):
                return
            s+=candidates[i]
            curr.append(candidates[i])
            helper(curr,s,i+1)
            s-= candidates[i]
            curr.pop()
            helper(curr,s,i+1)
            
            
            
        candidates.sort()
        helper([],0,0)
        return ret
        

    

        
        