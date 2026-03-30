class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        seen = set()

        adj = {}

        for a,b in edges:
            if a not in adj:
                adj[a] = []
            if b not in adj:
                adj[b] = []
            adj[a].append(b)
            adj[b].append(a)
            
        
        stack = []
        comp = 0
        for i in range(n):
            if i in seen:
                continue
            comp+=1
            stack.append(i)
            while stack:
                curr = stack.pop()
                if curr in seen:
                    continue
                seen.add(curr)
                print(curr)
                for edge in adj.get(curr,[]):
                    if edge not in seen:
                        stack.append(edge)
        return comp
        