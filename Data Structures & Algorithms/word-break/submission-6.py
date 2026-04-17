class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        m = [[] for _ in range(26)]
        lens = len(s)
        for word in wordDict:
            heapq.heappush(m[ord(word[0])-ord('a')],(len(word),word))

        canreach = [False] * (lens+1)
        canreach[0] = True
        for i in range(lens):
            if not canreach[i]:
                continue
            for l, word in m[ord(s[i])-ord('a')]:
                if l + i > lens:
                    break
                if s.startswith(word, i):
                    canreach[i+l] = True
                    if canreach[-1]:
                        return True
        
        return False

        
        