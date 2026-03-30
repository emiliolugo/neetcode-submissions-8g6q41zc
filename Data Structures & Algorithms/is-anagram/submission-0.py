class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        u = sorted(s)
        v = sorted(t)
        return u == v
        