class MedianFinder:

    def __init__(self):
        self.sz = 0
        self.s = []
        self.l = []

    def addNum(self, num: int) -> None:
        if self.sz == 0:
            self.s.append(-num)
        elif self.sz % 2 == 0: #even, must add to small heap
            if num > -self.s[0]: # bigger than last element on heap
                heapq.heappush(self.l,num)
                tmp = heapq.heappop(self.l)
                heapq.heappush(self.s, -tmp)
            else:
                heapq.heappush(self.s, -num)
        else:
            if num <= -self.s[0]: # small heap
                heapq.heappush(self.s,-num)
                tmp = heapq.heappop(self.s)
                heapq.heappush(self.l, -tmp)
            else:
                heapq.heappush(self.l, num)
        self.sz+=1
        

    def findMedian(self) -> float:
        if self.sz == 0:
            return 0
        elif self.sz % 2 == 0:
            return (self.l[0] - self.s[0]) / 2
        else:
            return -self.s[0]
        
        
