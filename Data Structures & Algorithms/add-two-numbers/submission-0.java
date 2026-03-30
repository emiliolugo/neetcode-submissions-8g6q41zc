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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headSum = new ListNode(0);
        ListNode currSum = headSum; 
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;

        //while both still have digits
        while(l1Curr!=null && l2Curr != null){
            int tmp = currSum.val;
            currSum.val = (currSum.val+l1Curr.val+l2Curr.val)%10;
            if(l1Curr.val+l2Curr.val+tmp >=10){
                currSum.next = new ListNode(1);
            }
            else{
                if(l1Curr.next!= null || l2Curr.next != null){
                currSum.next = new ListNode(0);}
            }
            currSum = currSum.next;
            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
        }
        
        while(l1Curr!=null){
            int tmp = currSum.val;
            currSum.val = (currSum.val+l1Curr.val)%10;
            if(l1Curr.val+tmp >=10){
                currSum.next = new ListNode(1);
            }
            else{
                if(l1Curr.next!= null){
                currSum.next = new ListNode(0);}
            }
            currSum = currSum.next;
            l1Curr = l1Curr.next;
        }

        while(l2Curr!=null){
            int tmp = currSum.val;
            currSum.val = (currSum.val+l2Curr.val)%10;
            if(l2Curr.val+tmp >=10){
                currSum.next = new ListNode(1);
            }
            else{
                if(l2Curr.next!=null){
                currSum.next = new ListNode(0);}
            }
            currSum = currSum.next;
            l2Curr = l2Curr.next;
        }



        return headSum;
        


    }
}
