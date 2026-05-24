class Solution:
    def integerBreak(self, n: int) -> int:
        if n == 2:
            return 1
        if n == 3:
            return 2
        dp = [0] * (n+1)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3
        for i in range(4,n+1):
            l = 0
            r = i
            while l <= r:
                dp[i] = max(dp[i],dp[l] * dp[r])
                l+=1
                r-=1
        return dp[-1]

        