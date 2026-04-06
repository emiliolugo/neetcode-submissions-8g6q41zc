# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.ret = float('-inf')
        test = self.helper(root)
        return max(test,self.ret)
    def helper(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = self.helper(root.left)
        right = self.helper(root.right)
        print(self.ret)
        self.ret = max(self.ret, left+right+root.val,root.val)
        return max(root.val + left, root.val+right, root.val)
        