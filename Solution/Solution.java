import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
     }

     public static void main(String[] str) {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        Solution obj = new Solution();
        obj.reverseKGroup(s1, 2);
     }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        
        int size = findLength(head);
        if (size < k) {
            return head;
        }
        ListNode current = dummy;
        ListNode cur = head;
        for (int i = 0; i < size / k ; i++) {

            ArrayList<ListNode> result = reverseK(cur, k);
            System.out.println("333" + result.get(0).val + " " + result.get(1).val + " " + result.get(2).val);
            //System.out.println(reverseK(cur, k).get(0).val + " " + reverseK(cur, k).get(1).val + " " + reverseK(cur, k).get(2).val);
            current.next = result.get(1);
            current = result.get(0);
            cur = result.get(2);
        }
        if (size % k != 0) {
            
            current.next = cur;
        }
        return dummy.next;
    }
    private ArrayList<ListNode> reverseK(ListNode head, int k) {
        System.out.println("11");
        ArrayList<ListNode> result = new ArrayList<ListNode>();
        ListNode prev = null;
        result.add(head);
        while (head != null && k > 0) {
            
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
                k--;
        }
        result.add(prev);
        result.add(head);
        System.out.println("222" + result.get(0).val + " " + result.get(1).val + " " + result.get(2).val);
        return result;
        
    }
    private int findLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
}