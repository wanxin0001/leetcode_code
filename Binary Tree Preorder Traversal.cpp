


/**
    Binary Tree Preorder Traversal 
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //first method is recursion
class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> result;
        if(root==NULL){
            return result;
        }
        preorderHelper(root,result);
        return result;
    }
    void preorderHelper(TreeNode* root, vector<int> &result){
        if(root==NULL){
            return;
        }
        result.push_back(root->val);
        if(root->left!=NULL){
            preorderHelper(root->left,result);
        }
        if(root->right!=NULL){
            preorderHelper(root->right,result);
        }
        
    }
};

//second method is iteration

/*Notice: it is very classic method. We need a stack and the method needs the following steps
(1) Push the root node into the stack.
(2) while the stack is not empty, do:
       a. pop the top node and print it.
       b. push the right child of the top node (if exists)
       c. push the left child of the top node (if exists)

*/
class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> result;
        if(root==NULL){
            return result;
        }
        stack<TreeNode*> Stack;
        //TreeNode cur = root;
        Stack.push(root);
        while(!Stack.empty()){
          TreeNode* cur = Stack.top();
          Stack.pop();
          result.push_back(cur->val);
          
          if(cur->right)
            Stack.push(cur->right);
          if(cur->left)
            Stack.push(cur->left);
            
            
        }
        
        return result;
    }
    
};