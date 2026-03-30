class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ret = []
        n = len(intervals)
        start = 0

        i = 0
        while i < n and intervals[i][1] < newInterval[0]:
            ret.append(intervals[i])
            i+=1

        if len(ret) == n:
            ret.append(newInterval)
            return ret

        curr = newInterval        
        while i < n and curr[1] >= intervals[i][0]:
            curr[0] = min(curr[0],intervals[i][0])
            curr[1] = max(curr[1],intervals[i][1])
            i+=1
        ret.append(curr)
        while i < n:
            ret.append(intervals[i])
            i+=1
        return ret
