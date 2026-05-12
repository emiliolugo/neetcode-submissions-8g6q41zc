class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        tracker = [0] * (amount+1)

        tracker[0] = 1
        


        for c in coins:
            for i in range(len(tracker)):
                if c + i >= len(tracker):
                    continue
                tracker[i+c] += tracker[i]
        return tracker[-1]

        