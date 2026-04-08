class Solution:

    def encode(self, strs: List[str]) -> str:
        result = ""
        for s in strs:
            result += str(len(s)) + "#" + s
        return result

    def decode(self, s: str) -> List[str]:
        ret = []
        curr_count = 0
        i = 0
        while i < len(s):
            if s[i] == '#':
                ret.append(s[i+1:i+curr_count+1])
                i = i + curr_count+1
                curr_count = 0
            else:
                curr_count = (curr_count * 10) + int(s[i])
                i+=1
        return ret
