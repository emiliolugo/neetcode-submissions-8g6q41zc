class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        lent = len(t)
        lens = len(s)

        tracker = [[0 for _ in range(lent)] for _ in range(lens)]

        for c in range(len(tracker[0])):
            for r in range(len(tracker)):
                if c > r:
                    tracker[r][c] = 0
                elif r == 0:
                    tracker[r][c] = 1 if s[r] == t[c] else 0
                elif c == 0:
                    tracker[r][c] = tracker[r-1][c]
                    if s[r] == t[c]:
                        tracker[r][c] += 1
                else:
                    tracker[r][c] = tracker[r-1][c]
                    if s[r] == t[c]:
                        tracker[r][c] += tracker[r-1][c-1]
        print(tracker)
        return tracker[-1][-1]

        