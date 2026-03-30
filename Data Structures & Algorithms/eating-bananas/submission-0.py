class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lowest, highest = 1, max(piles)
        if len(piles) == h:
            return highest
        while lowest <= highest:
            mid = lowest+(highest-lowest)//2
            if 0 <= highest-lowest <= 1:
                if self.canEat(lowest,h,piles):
                    return lowest
                return highest
            elif self.canEat(mid,h,piles):
                if self.canEat(mid-1,h,piles):
                    highest = mid-1
                else:
                    return mid
            else:
                lowest = mid+1
        return -1


    def canEat(self,k,h,piles):
        total_hours=0
        for pile in piles:
            pile_hour = pile//k if pile%k==0 else pile//k+1
            total_hours+=pile_hour
        return total_hours <= h

        