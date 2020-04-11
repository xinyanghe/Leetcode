/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
//         if (head == null || head.next == null) return head;
//         ListNode l1 = head;
//         ListNode l2 = head.next;
        
//         l1.next = swapPairs(l2.next);
//         l2.next = l1;
        
//         return l2;


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            ListNode fir = head;
            ListNode sec = head.next;
            
            fir.next = sec.next;
            sec.next = fir;
            prev.next = sec;
            
            prev = fir;
            head = prev.next;
        }
        return dummy.next;
    }
}
