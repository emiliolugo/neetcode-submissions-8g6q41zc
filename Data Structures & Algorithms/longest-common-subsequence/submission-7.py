class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)
        tracker = [[0 for _ in range(n+1)] for _ in range(m+1)]

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                diag = tracker[i + 1][j + 1]
                if text1[i] == text2[j]:
                    diag += 1
                tracker[i][j] += max(tracker[i + 1][j], tracker[i][j + 1], diag)
        return tracker[0][0]

        
        