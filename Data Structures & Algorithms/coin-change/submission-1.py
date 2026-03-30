class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if(len(coins) == 0):
            return -1
        memo = [0] * (amount+1)
        
        n = len(memo)

        for i in range(1, n):
            tmp_val = float('inf')
            for coin in coins:
                if i - coin < 0:
                    continue
                tmp_val = min(tmp_val, 1 + memo[i - coin])
            memo[i] = tmp_val
        
        return -1 if memo[-1] == float('inf') else memo[-1]