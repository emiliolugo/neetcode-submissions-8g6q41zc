class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        #have to prioritize interval wiht lowest end
        intervals.sort(key=lambda x: x[0])

        counter = 0
        last = intervals[0]
        for i in range(1,len(intervals)):
            start, end = intervals[i]
            if start >= last[0] and start < last[1]: #overlap
                counter+=1
                if last[1] > end:
                    last = intervals[i]
            else:
                last = intervals[i]
            
        return counter



        
        
        