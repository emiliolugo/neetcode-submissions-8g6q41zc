class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ret = []
        def helper(i: int, seen: List[set([])], curr: List[str]) -> None:
            if i == n:
                board = []
                for c in curr:
                    board.append("." * c + "Q" + "." * (n - 1 - c))
                ret.append(board)
                return
            
            for j in range(n):
                if j in seen[0]:
                    continue
                if i-j in seen[1]:
                    continue
                if i+j in seen[2]:
                    continue
                seen[0].add(j)
                seen[1].add(i-j)
                seen[2].add(i+j)
                curr.append(j)
                helper(i+1, seen, curr)
                curr.pop()
                seen[0].remove(j)
                seen[1].remove(i-j)
                seen[2].remove(i+j)
            return

        helper(0, [set([]),set([]),set([])], [])
        return ret


    
