class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        if len(position) == 1:
            return 1
        
        heap = []
        for i in range(len(position)):
            heap.append((-position[i],speed[i]))
        
        heapq.heapify(heap)

        eta = -1
        fleets = 0
        while heap:
            pos, sp = heapq.heappop(heap)
            print(pos, sp)
            curr = (target+pos) / sp
            print(curr)
            if curr > eta:
                fleets+=1
                eta = curr
        return fleets
        