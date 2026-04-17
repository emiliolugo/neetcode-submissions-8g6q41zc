class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        m = [[] for _ in range(26)]
        for word in wordDict:
            m[ord(word[0])-ord('a')].append(word)

        canreach = [False] * (len(s)+1)
        canreach[0] = True
        for i in range(len(s)):
            if not canreach[i]:
                continue
            for word in m[ord(s[i])-ord('a')]:
                if len(word) + i  - 1< len(s) and s.startswith(word, i):
                    canreach[i+len(word)] = True
                    if canreach[-1]:
                        return True
        
        return False

        
        