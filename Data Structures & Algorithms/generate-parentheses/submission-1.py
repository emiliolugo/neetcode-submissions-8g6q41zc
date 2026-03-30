class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ret = []
        def helper(o: int, c: int, curr: List[str]):
            if o > n:
                return
            if len(curr) == n * 2:
                ret.append(''.join(curr))
                return
            
            if o > c:
                curr.append(')')
                helper(o,c+1,curr)
                curr.pop()
            curr.append('(')
            helper(o+1,c,curr)
            curr.pop()
        helper(0,0,[])
        return ret
            
                
        