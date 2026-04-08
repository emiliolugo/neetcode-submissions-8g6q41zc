# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        root = preorder[0]
        inroot = 0
        for i in range(len(inorder)):
            if inorder[i] == root:
                inroot = i
                break
        left = self.buildTree(preorder[1:1+inroot], inorder[:inroot])
        right = self.buildTree(preorder[1+inroot:], inorder[inroot+1:])
        ret = TreeNode(root)
        ret.left = left
        ret.right = right
        return ret

        

        