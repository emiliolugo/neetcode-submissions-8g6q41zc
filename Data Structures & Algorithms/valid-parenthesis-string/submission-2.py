class Solution:
    def checkValidString(self, s: str) -> bool:
        counts = [0] * 3
        for char in s:
            if char == '(':
                counts[0]+=1
            if char == ')':
                counts[1]+=1
            if char == '*':
                counts[2]+=1
        if abs(counts[0]-counts[1]) > counts[2]:
            return False
        
        lo = 0
        hi = 0
        for char in s:
            if char == ')':
                lo-=1
                hi-=1 
            elif char == '(':
                lo+=1
                hi+=1
            else:
                lo -= 1
                hi += 1
            if hi < 0:
                    return False
            lo = max(0,lo)
        return lo == 0
            

        