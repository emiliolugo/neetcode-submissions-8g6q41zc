class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.balls = grid
        n = 0
        for i in range(0, len(self.balls)):
            for j in range(0, len(self.balls[0])):
                if(self.balls[i][j] == '1'):
                    n+=1
                    self.get_islands(i,j)
        return n
    def get_islands(self, i: int, j: int):
        if not (i >= 0 and i < len(self.balls) and j>= 0 and j < len(self.balls[0])): return
        if(self.balls[i][j] == '0'): return
        self.balls[i][j] = '0'
        self.get_islands(i+1,j)
        self.get_islands(i,j+1)
        self.get_islands(i-1,j)
        self.get_islands(i,j-1)
    
        