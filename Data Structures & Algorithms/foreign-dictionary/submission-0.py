class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj_list = {c: set() for w in words for c in w}
        indegree = {c: 0 for w in words for c in w}
        res = []
        q = deque()
        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i+1]
            min_len = min(len(w1), len(w2))
            
            if len(w1) > len(w2) and w1[:min_len] == w2[:min_len]:
                return ""
            
            for j in range(min_len):
                if w1[j] != w2[j]:
                    src, dst = w1[j], w2[j]
                    if dst not in adj_list[src]:
                        adj_list[src].add(dst)
                        indegree[dst] += 1
                    break
                    
        q = deque([c for c in indegree if indegree[c] == 0])
        res = []
        
        while q:
            top = q.popleft()
            res.append(top)
            for n in adj_list[top]:
                indegree[n]-=1
                if indegree[n] == 0:
                    q.append(n)
        if len(indegree) != len(res):
            return ''
        return ''.join(res)
        

        