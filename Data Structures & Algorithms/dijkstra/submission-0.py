class Solution:
    def shortestPath(self, n: int, edges: List[List[int]], src: int) -> Dict[int, int]:
        seen = set([])
        paths = [float('inf')] * n
        paths[src] = 0

        adj_list = {}

        for edge in edges:
            if edge[0] not in adj_list:
                adj_list[edge[0]] = []
            adj_list[edge[0]].append((edge[1], edge[2]))

        heap = []
        heapq.heappush(heap, (0, src))

        while heap:
            curr = heapq.heappop(heap)

            if curr[1] in seen:
                continue

            seen.add(curr[1])
            paths[curr[1]] = min(paths[curr[1]], curr[0])

            for neighbor in adj_list.get(curr[1], []):
                heapq.heappush(heap, (paths[curr[1]]+neighbor[1],neighbor[0]))

        ret = {}
        for index, path in enumerate(paths):
            ret[index] = -1 if path == float('inf') else path

        return ret