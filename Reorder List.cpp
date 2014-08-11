/*
Reorder List Total Accepted: 8301 Total Submissions: 43056 My Submissions
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    void reorderList(ListNode *head) {
        if(head==NULL||head->next==NULL||head->next->next==NULL){
            return;
        }
        ListNode* right = head;
        ListNode* mid = head->next; //left is shorter than right   so it is convenicent for the further merge
        ListNode* prev = NULL;
        while(right->next&&right->next->next){
            right = right->next->next;
            prev = mid;
            mid = mid->next;
        }
        prev->next = NULL;
        
        ListNode* cur = mid;
        prev = NULL;
        ListNode* next= cur->next;
        while(cur){
            if(prev==NULL){
                cur->next = NULL;
                prev = cur;
                cur = next;
                
            }
            else{
                next = cur ->next;
                cur ->next =prev;
                prev = cur;
                cur = next;
                
            }
        }
        ListNode* secondHead = prev;
        ListNode* firstHead = head;
        while(firstHead&&secondHead){
            ListNode* nextF = firstHead->next;
            firstHead->next = secondHead;
            ListNode* nextS = secondHead->next;
            secondHead->next = nextF;
            firstHead = nextF;
            secondHead = nextS;
        }
       
        
        return ;
    }
};