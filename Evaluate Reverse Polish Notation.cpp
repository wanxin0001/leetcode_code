/*
Evaluate Reverse Polish Notation Total Accepted: 9087 Total Submissions: 47471 My Submissions
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

/*
    Idea: use stack to store the value
    Notice:
    1. we need to put result into the stack again.
    2. tokens are string, so we need to transfer them int char[] by .c_str() and then transfer them into int by atoi(charr_array)
*/


class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        if(tokens.size()<=2)
            return atoi(tokens[0].c_str());
        int result =0;
        int first =0;
        int second =0;
        int i=0;
        stack<int> operands;
        while(i<tokens.size()){
            
            if(tokens[i]=="+"){
                second = operands.top();
                operands.pop();
                first = operands.top();
                operands.pop();
                result = first + second;
                operands.push(result);
                
            }
            else if(tokens[i]=="-"){
                second = operands.top();
                operands.pop();
                first = operands.top();
                 operands.pop();
                
                result = first-second;
                operands.push(result);
            }
            else if(tokens[i]=="*"){
                 second = operands.top();
                operands.pop();
                first = operands.top();
                 operands.pop();
                
                result = first*second;
                operands.push(result);
            }
            else if(tokens[i]=="/"){
                second = operands.top();
                operands.pop();
                first = operands.top();
                 operands.pop();
                
                result = first/second;
                operands.push(result);
            }
            else{
                operands.push(atoi(tokens[i].c_str()));
                
            }
            i++;
        }
        return operands.top();
    }
};