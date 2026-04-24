class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        ret = 0
        tracker = [[0 for _ in range(len(text2)+1)] for _ in range(len(text1)+1)]

        for i in range(1,len(text1)+1):
            for j in range(1,len(text2)+1):
                if text1[i-1] == text2[j-1]:
                    tracker[i][j] = tracker[i-1][j-1] + 1
                else:  
                    tracker[i][j] = max(tracker[i-1][j],tracker[i][j-1])
                
                ret = max(tracker[i][j],ret)
        return ret
        