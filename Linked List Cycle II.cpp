/*
	Linked List Cycle II Total Accepted: 9760 Total Submissions: 32061 My Submissions
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

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
    ListNode *detectCycle(ListNode *head) {
        if(head==NULL)
            return NULL;
        ListNode* fast = head;
        ListNode* slow = head;
        
        while(fast->next&&fast->next->next){
            fast = fast->next->next;
            slow = slow->next;
            if(fast==slow)
                break;
        }
        if(!fast->next||!fast->next->next)
            return NULL;
        slow = head;
        while(fast!=slow){
            slow = slow->next;
            fast = fast->next;
        }
        return fast;
    }
};