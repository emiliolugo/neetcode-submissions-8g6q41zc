class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l,r = 0, len(matrix) * len(matrix[0]) - 1

        while l <= r:
            mid_start = (r + l) // 2
            ls = mid_start // len(matrix[0])
            mid = mid_start % len(matrix[0])

            search = matrix[ls][mid]
            if search == target:
                return True
            elif search < target:
                l = mid_start + 1
            else:
                r = mid_start - 1

        return False
        