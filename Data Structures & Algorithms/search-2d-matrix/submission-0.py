class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in range(len(matrix)):
            left, right = 0, len(matrix[0])-1
            while left <= right:
                mid = left + (right-left)//2
                if matrix[i][mid] == target:
                    return True
                elif matrix[i][mid] < target:
                    left = mid+1
                else:
                    right = mid-1
        return False