class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj_list = {}

        for start, end, cost in flights:
            if start not in adj_list:
                adj_list[start] = []
            adj_list[start].append((cost,end))
        
        seen = [[False for _ in range(k+1)] for _ in range(n)]
        heap = []
        heapq.heappush(heap,(0,src,0))

        while heap:
            d, curr, stops = heapq.heappop(heap)
            if curr == dst:
                return d
            if stops > k or seen[curr][stops]:
                continue
            
            seen[curr][stops] = True
            
            for cost, end in adj_list.get(curr,[]):
                if (stops == k and end != dst) or stops > k or seen[end][stops]:
                    continue
                heapq.heappush(heap,(d + cost, end, stops+1))
        return -1
        
        