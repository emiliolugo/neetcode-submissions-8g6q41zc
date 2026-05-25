class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if not edges:
            return [0]
        ret = []
        adj = {}
        gh = n

        for src, dst in edges:
            if src not in adj:
                adj[src] = []
            if dst not in adj:
                adj[dst] = []
            adj[src].append(dst)
            adj[dst].append(src)
        
        def find_height(root, parent):
            
            mx = 0
            for child in adj[root]:
                if child == parent:
                    continue
                mx = max(mx,find_height(child,root))
                if mx == gh:
                    break
            return 1 + mx
        for i in range(n):
            h = find_height(i, -1)
            if h < gh:
                gh = h
                ret = []
            if h <= gh:
                ret.append(i)
        
        return ret
        