class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        visited = set([])
        m,n = len(grid), len(grid[0])
        heap = [(grid[0][0],0,0)]
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        while heap:
            distance, i, j = heapq.heappop(heap)

            if (i,j) in visited:
                continue
            visited.add((i,j))

            if i == m-1 and j == n-1:
                return distance

            for di, dj in dirs:
                ni,nj = i+di, j+dj
                if ni >= 0 and ni < m and nj >= 0 and nj < n:
                    heapq.heappush(heap,(max(distance,grid[ni][nj]),ni,nj))
                    
        
        return dist[(m-1,n-1)]

        

        