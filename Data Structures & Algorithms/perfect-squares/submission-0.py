class Solution:
    def numSquares(self, n: int) -> int:
        sqrt = int(n ** 0.5)
        dp = [float('inf')] * (n+1)
        dp[0] = 0
        
        for i in range(1,n+1):
            for c in range(1,sqrt+1):
                square = c * c
                if square > i:
                    break
                dp[i] = min(dp[i],dp[i-square]+1)

        return dp[-1]