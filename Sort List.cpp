/*
Sort List Total Accepted: 8033 Total Submissions: 41046 My Submissions
Sort a linked list in O(n log n) time using constant space complexity.
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
    ListNode *sortList(ListNode *head) {
        if(head==NULL)
            return head;
            
        int i=0;
        ListNode* cur=head;
        while(cur){
            i++;
            cur = cur->next;
        }
        ListNode* newHead = sortHelper(head, i);
        
        return newHead;
    }
    ListNode* sortHelper(ListNode *head,int len){
        
        if(len==1||len==0){
            return head;
        }
        int mid = len/2;
        ListNode* right = head;
        ListNode* left = head;
        int i=0;
        while(mid-1!=i){
            right = right->next;
            i++;
        }
        ListNode* tmp = right;
        
        right = right->next;
        tmp->next =NULL;
        
        left = sortHelper(left, mid);
        right = sortHelper(right, len-mid);
        
        ListNode* newHead = merge(left,right);
        return newHead;
        
        
    }
    ListNode* merge(ListNode *left, ListNode* right){
        ListNode* newHead = new ListNode(1);
        ListNode* cur = newHead;
        while(left||right){
            int leftVal;
            int rightVal;
            if(left){
                leftVal = left->val;
            }
            else
                leftVal = INT_MAX;
            if(right)
                rightVal = right->val;
            else
                rightVal = INT_MAX;
            
            
            if(leftVal<rightVal){
                cur->next = new ListNode(leftVal);
                cur = cur->next;
                left = left->next;
            }
            else{
                cur->next = new ListNode(rightVal);
                cur = cur->next;
                right =right->next;
            }
            
        }
        cur = newHead->next;
        delete newHead;
        return cur;
    }
};