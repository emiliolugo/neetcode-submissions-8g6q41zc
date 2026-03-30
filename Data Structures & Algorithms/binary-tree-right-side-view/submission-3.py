# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        ret = []
        lvl = -1

        que = deque()
        que.append((root,0))

        while que:
            node, currl = que.popleft()
            if currl > lvl:
                ret.append(node.val)
                lvl = currl
            if node.right:
                que.append((node.right,currl+1))
            if node.left:
                que.append((node.left,currl+1))
        return ret



        