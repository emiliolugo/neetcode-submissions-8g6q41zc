class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        memo = {}
        
        def dfs(i: int, canBuy: bool) -> int:
            if i >= len(prices):
                return 0
            
            if(i, canBuy) in memo:
                return memo[(i,canBuy)]

            if (canBuy):
                memo[(i,canBuy)] = max(
                    -prices[i] + dfs(i + 1, False),
                    dfs(i + 1, True)
                )
                return memo[(i,canBuy)]
            else:
                memo[(i,canBuy)] = max(
                    prices[i] + dfs(i + 2, True),
                    dfs(i + 1, False)
                )
                return memo[(i,canBuy)]
            
        
        return dfs(0,True)
        
        
        