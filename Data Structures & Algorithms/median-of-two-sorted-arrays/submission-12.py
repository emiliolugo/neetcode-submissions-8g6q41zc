class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1,nums2 = nums2, nums1
        
        n = len(nums1)
        m = len(nums2)
        half = (n+m) // 2

        l,r = 0, n-1
        
        while True:
            mid = (r+l) // 2
            other = half-mid-2

            Al = float('-inf') if mid < 0 else nums1[mid]
            Ar = float('inf') if mid+1 >= n else nums1[mid+1]
            Bl = float('-inf') if other < 0 else nums2[other]
            Br = float('inf') if other+1 >= m else nums2[other+1]

            if Al <= Br and Bl <= Ar:
                if (n+m) & 1:
                    return min(Ar,Br)
                else:
                    return (max(Al,Bl)+min(Ar,Br)) / 2
            elif Al > Br:
                r = mid - 1
            else:
                l = mid + 1
        return -1

        