class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        wordList.append(beginWord)

        wordDict = {}
        seen = set([])
        wordLen = len(wordList[0])
        for word in wordList:
            for i in range(wordLen):
                if word[:i] + '*' + word[i+1:] not in wordDict:
                    wordDict[word[:i] + '*' + word[i+1:]] = []
                wordDict.get(word[:i] + '*' + word[i+1:]).append(word)

            
        queue = deque()
        queue.append((endWord,1))

        while queue:
            word, height = queue.popleft()  
            print('popping' + word)    
            if word == beginWord:
                return height
            seen.add(word) 
            for i in range(wordLen):
                for child in wordDict.get(word[:i] + '*' + word[i+1:],[]):
                    if child in seen:
                        continue
                    queue.append((child,height+1))
                    seen.add(child)
        return 0
    
    


        