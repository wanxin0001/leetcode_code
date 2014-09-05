/*
Copy List with Random Pointer Total Accepted: 18397 Total Submissions: 79236 My Submissions
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode old = head;
        while (old != null) {
            RandomListNode tmp = new RandomListNode(old.label);
            map.put(old, tmp);
            tail.next = tmp;
            tail = tail.next;
            old = old.next;
        }
        
        old = head;
        tail = dummy.next;
        while (old != null) {
            if (old.random != null) {
                tail.random = map.get(old.random);
            }
            
            old = old.next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}