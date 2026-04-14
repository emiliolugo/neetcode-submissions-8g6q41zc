class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj = [[] for _ in range(n)]
        for u,v, cost in flights:
            adj[u].append((cost,v))

        resp = [float('inf')] * n
        resp[src] = 0

        q = deque()
        q.append((0,src,0))

        while q:
            cost, curr, stops = q.popleft()
            if stops > k:
                continue
            for w, nei in adj[curr]:
                nxt = w + cost
                if nxt < resp[nei]:
                    resp[nei] = nxt
                    q.append((resp[nei],nei,stops+1))

        return resp[dst] if resp[dst] != float('inf') else -1
            
        