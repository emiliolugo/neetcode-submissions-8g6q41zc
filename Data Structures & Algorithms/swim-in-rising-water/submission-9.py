class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        visited = set([])
        m,n = len(grid), len(grid[0])
        heap = [(grid[0][0],0,0)]
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        while heap:
            distance, i, j = heapq.heappop(heap)

            if i == m-1 and j == n-1:
                return distance
            for di, dj in dirs:
                ni,nj = i+di, j+dj
                if ni < 0 or ni >= m or nj < 0 or nj >= n or (ni,nj) in visited:
                    continue
                heapq.heappush(heap,(max(distance,grid[ni][nj]),ni,nj))
                visited.add((ni,nj))
                    
        
        return -1

        

        