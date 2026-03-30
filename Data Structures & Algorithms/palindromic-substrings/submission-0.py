class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0
        n = len(s)
        for i in range(n):

            for j in range(2):
                l,r = i,i+j

                while l >= 0 and r < n and s[r] == s[l]:
                    count+= 1
                    l-=1
                    r+=1
        return count