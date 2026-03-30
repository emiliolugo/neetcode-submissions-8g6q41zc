class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        
        c1,c2,c3 = -1,-1,-1

        for a,b,c in triplets:
            if a <= target[0] and b <= target[1] and c <= target[2]:
                c1 = max(a,c1)
                c2 = max(b,c2)
                c3 = max(c,c3)
        return c1 == target[0] and c2 == target[1] and c3 == target[2]