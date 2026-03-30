from collections import Counter

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        counts = {}

        for index,char in enumerate(s):
            counts[char] = index
        ret = []

        final_ind = 0
        start_ind = 0
        for index, char in enumerate(s):
            final_ind = max(final_ind, counts[char])
            if index == final_ind:
                ret.append(final_ind-start_ind + 1)
                start_ind = final_ind+1
        return ret
        