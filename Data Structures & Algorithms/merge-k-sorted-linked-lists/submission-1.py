# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for i in range(len(lists)):
            if(not lists[i]):
                continue
            heapq.heappush(heap, (lists[i].val, i))
            lists[i] = lists[i].next
        
        head = ListNode(-1)
        curr = head

        while heap:
            res = heapq.heappop(heap)
            curr.next = ListNode(res[0])
            curr = curr.next

            if lists[res[1]]:
                heapq.heappush(heap, (lists[res[1]].val, res[1]))
                lists[res[1]] = lists[res[1]].next

        return head.next
            
        