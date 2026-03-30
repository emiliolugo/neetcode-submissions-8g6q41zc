from sortedcontainers import SortedDict
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) / groupSize != len(hand) // groupSize:
            return False
        
        d = SortedDict({})

        for h in hand:
            d[h] = d.get(h, 0) + 1

        
        while d:
            first = d.keys()[0]
            for key in range(first, first + groupSize):
                if key not in d:
                    return False
                d[key] -= 1
                if d[key] == 0:
                    del d[key]
        
        return not len(d) > 0





        