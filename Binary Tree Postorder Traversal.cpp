/*
    Binary Tree Postorder Traversal Total Accepted: 12510 Total Submissions: 41534 My Submissions
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> result;
        if(root==NULL)
            return result;
        postorderHelper(root,result);
        return result;
    }
    void postorderHelper(TreeNode *root, vector<int>&result){
        if(root==NULL)
            return;
        if(root->left!=NULL){
            postorderHelper(root->left,result);
        }
        if(root->right!=NULL){
            postorderHelper(root->right,result);
        }
        result.push_back(root->val);
    }
};