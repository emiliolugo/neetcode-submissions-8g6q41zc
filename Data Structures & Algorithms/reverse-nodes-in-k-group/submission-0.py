# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:

        dummy = head
        counter = 0
        while(dummy):
            counter+=1
            dummy = dummy.next
        
        curr = head
        ret = head
        prev = None

        dummy = ListNode(0)
        dummy.next = head
        gt = dummy
        iters = counter // k

        for i in range(iters):
            tail = curr
            prev = None

            for j in range(k):
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp
            
            gt.next = prev

            tail.next = curr

            gt = tail
            
           

        return dummy.next

                

        