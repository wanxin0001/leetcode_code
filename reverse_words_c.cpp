/*
Reverse Words in a String Total Accepted: 6344 Total Submissions: 45473 My Submissions
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/
class Solution {
public:
    void reverseWords(string &s) {
        if(s.length()==0)
            return;
     
        istringstream iss(s);
        string result;
         string sub;
           
       while(iss>>sub)
        {
           
            result.insert(0,sub);
            result.insert(0," ");
            
        } 
        result.erase(0,1);
        s = result;
    }
};