"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None:
            return None
        
        M = {}
        curr = head

        while curr:
            M[curr] = Node(curr.val)
            curr = curr.next

        curr = head

        while curr:
            copy = M[curr]
            copy.next = M.get(curr.next)
            copy.random = M.get(curr.random)
            curr = curr.next
        
        return M[head]
        