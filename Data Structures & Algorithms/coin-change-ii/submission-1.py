class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        tracker = [0] * (amount+1)

        tracker[0] = 1
        


        for c in coins:
            for i in range(c, len(tracker)):
                tracker[i] += tracker[i-c]

        return tracker[-1]

        