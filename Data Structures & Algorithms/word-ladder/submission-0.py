class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        wordList.append(beginWord)
        seen = set([])

        queue = deque()
        queue.append((endWord,1))

        while queue:
            word, height = queue.popleft()
            print("popping" + word)
      
            if word == beginWord:
                return height
            seen.add(word) 
            for w in wordList:
                print(w + " " + word)
                if w in seen:
                    continue
                if self.jump(word, w):
                    queue.append((w,height+1))
                    seen.add(w)
        return 0
    def jump(self,first: str, second: str) -> bool:
        misses = 0
        for i in range(len(first)):
            if(first[i] != second[i]):
                misses+=1
            if(misses > 1):
                return False
        return True

    


        