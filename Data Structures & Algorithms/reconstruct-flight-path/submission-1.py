class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # build adj_list

        graph = {}

        for src, dst in tickets:
            if src not in graph:
                graph[src] = []
            graph[src].append(dst)

        for k,v in graph.items():
            v.sort(reverse=True)
        
        stack = ['JFK']
        ret = []

        while stack:
            nxt = stack[-1]
            
            if nxt in graph and graph[nxt]:
                nn = graph[nxt].pop()
                stack.append(nn)
            else:
                ret.append(stack.pop())
        return ret[::-1]
            
        