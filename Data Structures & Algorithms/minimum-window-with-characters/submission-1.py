class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        if t == s:
            return s
        
        def valid(slis: List[str], tlis: List[str]):
            print(slis,tlis)
            for i in range(len(slis)):
                if slis[i] < tlis[i]:
                    return False
            return True
        # counts 
        
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
        
        slis = [0] * len(tlis)
        
        l = 0

        ret = ''
        for r in range(len(s)):
            if s[r] in indices:
                slis[indices[s[r]]]+=1
            while l <= r and valid(slis,tlis):
                print('called at' + str(l) + 'with ' + s[l:r+1])
                if r+1-l < len(ret) or ret == '':
                    ret = s[l:r+1]
                if s[l] in indices:
                    slis[indices[s[l]]]-=1
                l +=1
                
        return ret
                