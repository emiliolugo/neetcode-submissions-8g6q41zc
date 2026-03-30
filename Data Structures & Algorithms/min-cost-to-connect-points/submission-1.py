class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        cost = 0
        seen = set()

        heap = []
        heap.append((0, (points[0][0],points[0][1])))
        
        while len(seen) < len(points):
            weight, curr_point = heapq.heappop(heap)

            if curr_point in seen:
                continue
            
            cost+= weight
            seen.add(curr_point)

            for point in points:
                tup = (point[0],point[1])
                if tup in seen:
                    continue
                weight = abs(point[0]-curr_point[0]) + abs(point[1]-curr_point[1])
                heapq.heappush(heap,(weight,tup))

        return cost



        