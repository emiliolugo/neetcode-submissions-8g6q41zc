class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if len(word1) == 0 and len(word2) == 0:
            return 0
        if len(word1) > len(word2):
            word1,word2 = word2, word1

        n = len(word1)
        m = len(word2)
        
        bottom = [n-i for i in range(n+1)]
        top = [float('inf')] * (n+1)
        for j in range(m-1,-1,-1):
            top = [float('inf')] * (n+1)
            top[-1] = m-j
            for i in range(n-1,-1,-1):
                if word1[i] == word2[j]:
                    top[i] = bottom[i+1]
                else:
                    top[i] = 1 + min(bottom[i+1], bottom[i],top[i+1])
            bottom = top
        return top[0]        