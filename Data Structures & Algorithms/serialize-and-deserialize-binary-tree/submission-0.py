# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str: # gives preorder encoding
        if not root:
            return ""
        ls = []
        # def helper(root) -> None:
        #     if not root:
        #         ls.append("N")
        #         return
            
        #     ls.append(str(root.val))
        #     helper(root.left)
        #     helper(root.right)
        # helper(root)
        q = deque()
        q.append(root)
        while q:
            curr = q.popleft()
            if not curr:
                ls.append('N')
                continue
            ls.append(str(curr.val))
            q.append(curr.left)
            q.append(curr.right)
            
        return "#".join(ls)

        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        if data == "":
            return None
        ret, curr = None, None

        q = deque()
        ls = data.split('#')
        if ls and ls[0] != 'N':
            ret = TreeNode(int(ls[0]))
            q.append(ret)
        else:
            return None
        nxt = 1
        while q:
            curr = q.popleft()
            
            children = [None,None]
            for i in range(2):
                if nxt < len(ls):
                    if ls[nxt] != 'N':
                        children[i] = TreeNode(int(ls[nxt]))
                    nxt+=1
            
            if children[0]:
                curr.left = children[0]
                q.append(children[0])
            if children[1]:
                curr.right = children[1]
                q.append(children[1])
            

        return ret
