class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        n = len(s)
        tmp = []
        self.helper(s, tmp, 0, '', 0, n)
        return self.res

    def helper(self, s: str, curr_list: List[str], index: int, curr: str, curr_len: int, n: int) -> None:
        if index == n:
            if curr_len == n:
                self.res.append(curr_list[:])
            return
        
        if self.is_palindrome(curr + s[index]):
            curr_list.append(curr + s[index])
            self.helper(s, curr_list, index + 1, '', curr_len + len(curr + s[index]), n)
            curr_list.pop()
        
        self.helper(s, curr_list, index + 1, curr + s[index], curr_len, n)

    def is_palindrome(self, s: str) -> bool:
        return s == s[::-1]