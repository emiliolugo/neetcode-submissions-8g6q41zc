class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if not nums1:
            if len(nums2) & 1:
                return nums2[len(nums2)//2]
            else:
                return (nums2[len(nums2)//2] + nums2[len(nums2)//2 - 1] ) / 2
        if not nums2:
            if len(nums1) & 1:
                return nums1[len(nums1)//2]
            else:
                return (nums1[len(nums1)//2] + nums1[len(nums1)//2 - 1] ) / 2
        if nums1[0] > nums2[-1]:
            nums1,nums2 = nums2, nums1


        med1, med2 = -1,-1
        m1,m2 = float('inf'), float('inf')
        n = len(nums1)
        m = len(nums2)
        if (m+n) & 1:
            med1,med2 = (m+n)//2,(m+n)//2
        else:
            med1 = (m+n) // 2 - 1
            med2 = (m+n)//2
        
        if nums1[-1] <= nums2[0]: # all in proper order can return right away
            if med1 < n:
                m1 = nums1[med1]
            else:
                m1 = nums2[med1-n]
            if med2 < n:
                m2 = nums1[med2]
            else:
                m2 = nums2[med2-n]
            return (m1+m2) / 2
        rn, ln = n-1,0
        

        while ln <= rn:
            mid = (ln+rn) // 2
            el = nums1[mid]
            rm, lm = m, 0
            while lm < rm:
                mid2 = (lm+rm) // 2
                if el <= nums2[mid2]:
                    rm = mid2
                else:
                    lm = mid2+1
            r1 = mid + lm
            rm, lm = m, 0
            while lm < rm:
                mid2 = (lm+rm) // 2
                if el < nums2[mid2]:
                    rm = mid2
                else:
                    lm = mid2+1
            r2 = mid + lm
            

            if r1 <= med1 <= r2:
                m1 = nums1[mid]
                if med1 == med2:
                    return m1
            if r1 <= med2 <= r2:
                m2 = nums1[mid]
            if m1 != float('inf') and m2 != float('inf'):
                return (m1+m2) / 2
            
            if r2 <= med1:
                ln = mid+1
            else:
                rn = mid - 1

        rm, lm = m-1, 0
        while lm <= rm:
            mid = (lm+rm) // 2
            el = nums2[mid]

            rn, ln = n, 0
            while ln < rn:
                mid2 = (ln+rn) // 2
                if el <= nums1[mid2]:
                    rn = mid2
                else:
                    ln = mid2+1
            r1 = mid + ln

            rn, ln = n, 0
            while ln < rn:
                mid2 = (ln+rn) // 2
                if el < nums1[mid2]:
                    rn = mid2
                else:
                    ln = mid2+1
            r2 = mid + ln

            if r1 <= med1 <= r2:
                m1 = nums2[mid]
                if med1 == med2:
                    return m1

            if r1 <= med2 <= r2:
                m2 = nums2[mid]

            if m1 != float('inf') and m2 != float('inf'):
                return (m1+m2) / 2

            if r2 < med1:
                lm = mid + 1
            else:
                rm = mid - 1
        return -1