"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        if len(intervals) < 2:
            return len(intervals)

        intervals.sort(key=lambda x: x.start)
        rooms = []

        for interval in intervals:
            if rooms and rooms[0] <= interval.start:
                heapq.heapreplace(rooms, interval.end)
            else:
                heapq.heappush(rooms, interval.end)
        return len(rooms)
        