class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        if t == s:
            return s
        
        indices = {}
        tlis = []

        index = 0
        for c in t:
            if c not in indices:    
                indices[c] = index
                index+=1
                tlis.append(1)
            else:
                tlis[indices[c]]+=1
                
        l = 0
        tracker = 0
        ret = ''
        for r in range(len(s)):
            if s[r] in indices:
                tlis[indices[s[r]]]-=1
                if(tlis[indices[s[r]]] == 0):
                    tracker+=1
                while l <= r and tracker == len(tlis):
                    if r+1-l < len(ret) or ret == '':
                        ret = s[l:r+1]
                    if s[l] in indices:
                        tlis[indices[s[l]]]+=1
                        if tlis[indices[s[l]]] > 0:
                            tracker-=1
                    l+=1
                                
        return ret
                