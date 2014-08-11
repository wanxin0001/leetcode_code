/*
Linked List Cycle Total Accepted: 13862 Total Submissions: 40061 My Submissions
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head==NULL)
            return false;
        ListNode* fast = head;
        ListNode* slow = head;
        while(fast->next&&fast->next->next){
            fast =fast->next->next;
            slow = slow->next;
            if(fast==slow)
                return true;
        }
        return false;
    }
};