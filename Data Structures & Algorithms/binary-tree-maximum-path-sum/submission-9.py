# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.ret = float('-inf')
        self.helper(root)
        return self.ret
    def helper(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = max(self.helper(root.left),0)
        right = max(self.helper(root.right),0)
        self.ret = max(self.ret, left+right+root.val,root.val)
        return root.val + max(left,right)
        