class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [[0] * m for _ in range(n)]
        grid[0][0] = 1
        for i, row in enumerate(grid):
            for j, col in enumerate(grid[0]):
                if i == 0 and j == 0:
                    continue
                if i > 0:
                    grid[i][j] += grid[i-1][j]
                if j > 0:
                    grid[i][j] += grid[i][j-1]
        return grid[-1][-1]