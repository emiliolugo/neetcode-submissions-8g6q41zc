class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        dist = {}
        m,n = len(grid), len(grid[0])

        for i in range(m): # adj list
            for j in range(n):
                dist[(i,j)] = float('inf')
                
        dist[(0,0)] = grid[0][0]

        heap = []
        heapq.heappush(heap,(grid[0][0],(0,0)))

        while heap:
            distance, curr = heapq.heappop(heap)
            i,j = curr
            
            if distance > dist[curr]:
                continue
            
            if i+1 < m:
                currd = dist[(i+1,j)]
                if currd > max(distance,grid[i+1][j]):
                    dist[(i+1,j)] = max(distance,grid[i+1][j])
                    heapq.heappush(heap,(dist[(i+1,j)],(i+1,j)))
            if i-1 >= 0:
                currd = dist[(i-1,j)]
                if currd > max(distance,grid[i-1][j]):
                    dist[(i-1,j)] = max(distance,grid[i-1][j])
                    heapq.heappush(heap,(dist[(i-1,j)],(i-1,j)))
            if j+1 < n:
                currd = dist[(i,j+1)]
                if currd > max(distance,grid[i][j+1]):
                    dist[(i,j+1)] = max(distance,grid[i][j+1])
                    heapq.heappush(heap,(dist[(i,j+1)],(i,j+1)))
            if j-1 >= 0:
                currd = dist[(i,j-1)]
                if currd > max(distance,grid[i][j-1]):
                    dist[(i,j-1)] = max(distance,grid[i][j-1])
                    heapq.heappush(heap,(dist[(i,j-1)],(i,j-1)))
    
        
        return dist[(m-1,n-1)]

        

        