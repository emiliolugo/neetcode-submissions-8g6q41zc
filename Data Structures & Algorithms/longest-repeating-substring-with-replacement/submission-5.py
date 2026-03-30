class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        counts = {}
        if(len(s) == 0):
            return 0
        l = 0
        ret = 0
        for i in range(len(s)):
            counts[s[i]] = counts.get(s[i],0)+1

            while (i - l + 1) - max(counts.values()) > k:
                if counts[s[l]] == 1:
                    del counts[s[l]]
                else:
                    counts[s[l]] -=1
                l+=1

            ret = max(ret, i-l+1)

        
        return ret
                


