class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        seen = set()
        dist = [float('inf')] * n
        dist[k-1] = 0

        adj_list = {}

        for time in times:
            if time[0]-1 not in adj_list:
                adj_list[time[0] -1] = []
            adj_list[time[0]-1].append((time[1]-1,time[2]))

        heap = []
        heapq.heappush(heap,(0,k-1))

        while heap:
            curr = heapq.heappop(heap)

            if curr[1] in seen:
                continue
            seen.add(curr[1])

            dist[curr[1]] = min (dist[curr[1]], curr[0])

            for neighbor in adj_list.get(curr[1], []):
                heapq.heappush(heap,(dist[curr[1]] + neighbor[1], neighbor[0]))
        
        ret = -1
        for d in dist:
            if(d == float('inf')):
                return -1
            ret = max(d,ret)
        return ret

        