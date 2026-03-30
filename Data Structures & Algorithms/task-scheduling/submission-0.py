from collections import Counter

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:

        counts = Counter(tasks)

        heap = [-c for c in counts.values()]

        
        heapq.heapify(heap)
        
        queue = deque()
        timestamp = 0
        while heap or queue:
            timestamp+=1
            if heap:
                count = heapq.heappop(heap)+1
                if count != 0:
                    queue.append((timestamp + n, count))
            if queue and queue[0][0] == timestamp:
                heapq.heappush(heap,queue.popleft()[1])
        return timestamp

            



                    