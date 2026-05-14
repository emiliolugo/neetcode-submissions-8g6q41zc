class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = None

    class Trie:
        def __init__(self):
            self.root = Solution.TrieNode()
        
        def add_word(self, word: str) -> None:
            curr = self.root
            for c in word:
                if not curr.children[ord(c) - ord('a')]:
                    curr.children[ord(c) - ord('a')] = Solution.TrieNode()
                curr = curr.children[ord(c) - ord('a')]
            curr.isEnd = word

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = self.Trie()
        root = trie.root
        sWords = set(words)
        for word in words:
            trie.add_word(word)
        ret = []

        def dfs(i: int, j: int, curr) -> None:
            if (i < 0 or i >= len(board) or j < 0 or j >= len(board[0])):
                return
            if '#' in board[i][j] or not curr.children[ord(board[i][j]) - ord('a')]:
                return
            next_node = curr.children[ord(board[i][j]) - ord('a')]
            if next_node.isEnd:
                ret.append(next_node.isEnd)
                next_node.isEnd = None
            tmp = board[i][j]
            board[i][j] = '#' + board[i][j]

            dfs(i+1, j, next_node)
            dfs(i-1, j, next_node)
            dfs(i, j+1, next_node)
            dfs(i, j-1, next_node)

            board[i][j] = tmp

        for i in range(len(board)):
            for j in range(len(board[0])):
                tmp = dfs(i, j, root)
        return ret