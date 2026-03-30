class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        if n < 2:
            return 0 if n < 1 else len[0]
        min_last, min_pen = cost[-1], cost[-2]

        for i in range(n-3, -1, -1):
            tmp = min(cost[i] + min_pen, cost[i] + min_last)
            min_last = min_pen
            min_pen = tmp
        return min(min_last,min_pen)
