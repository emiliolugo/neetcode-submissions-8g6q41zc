class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:

        def is_valid(x:int, y: int):
            return x >= 0 and y >= 0 and x < len(matrix) and y < len(matrix[0])

        dp = [[1] * len(matrix[0]) for _ in range(len(matrix))]

        heap = [(matrix[i][j],i,j) for i in range(len(matrix)) for j in range(len(matrix[0]))]

        heapq.heapify(heap)

        neighbors = [(0,1),(1,0),(-1,0),(0,-1)]
        mx = 1
        while heap:
            val, i, j = heapq.heappop(heap)
            for x,y in neighbors:
                if is_valid(i+x,j+y) and matrix[i+x][j+y] < val:
                    dp[i][j] = max(dp[i][j],1 + dp[i+x][j+y])
            mx = max(mx,dp[i][j])

        return mx
                
        