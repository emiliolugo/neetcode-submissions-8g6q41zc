/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(int i = 0; i < lists.length; i++){
            if(lists[i] == null) continue;
            pq.offer(new int[]{lists[i].val, i});
            lists[i] = lists[i].next;
        }   

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(!pq.isEmpty()){
            int[] res = pq.poll();
            curr.next = new ListNode(res[0]);
            curr = curr.next;
            if(lists[res[1]] != null){
            pq.offer(new int[]{lists[res[1]].val,res[1]});
            lists[res[1]] = lists[res[1]].next;}
        }

        return head.next;

    }
}
