class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        c1,c2,c3 = -1,-1,-1

        for first,second,third in triplets:
            if first <= target[0] and second <= target[1] and third <= target[2]:
                c1 = max(c1,first)
                c2 = max(c2,second)
                c3 = max(c3,third)   
            if c1 == target[0] and c2 == target[1] and c3 == target[2]:             
                return True
        return False