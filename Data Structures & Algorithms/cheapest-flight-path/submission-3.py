class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj_list = {}

        for start, end, cost in flights:
            if start not in adj_list:
                adj_list[start] = []
            adj_list[start].append((cost,end))
        
        seen = set([])
        heap = []
        heapq.heappush(heap,(0,src,0))

        while heap:
            d, curr, stops = heapq.heappop(heap)
            if curr == dst and stops <= k+1:
                return d
            if curr in seen or stops > k:
                continue
            
            seen.add((curr, stops))
            for cost, end in adj_list.get(curr,[]):
                heapq.heappush(heap,(d + cost, end, stops+1))
        return -1




        
        