class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = [float('inf')] * len(triangle[-1])

        for j in range(len(triangle)):
            r = triangle[j]

            if j == 0:
                dp[0] = r[0]
                continue

            dp[j] = dp[j - 1] + r[j]

            for i in range(j - 1, 0, -1):
                dp[i] = min(dp[i - 1], dp[i]) + r[i]

            dp[0] = dp[0] + r[0]

        return min(dp)