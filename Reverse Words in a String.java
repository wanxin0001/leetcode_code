/*Reverse Words in a String Total Accepted: 8538 Total Submissions: 62160 My Submissions
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

*/
/*
	In this simple problem, I face several bugs. 
	1. when compared with two strings, I need to use string1.equals(string2), otherwise it would compare the reference.
	2. when using split, there would exist the "", so we need to check it.
	3. at the end, we need to check s.length() before using s.substring(0,s.length()-1);
*/
public class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()==0)
            return s;
        String[] seq = s.split(" ");
        int len = seq.length;
        s = new String();
        for(int i=len-1;i>=0;i--){
            if(!seq[i].equals("")){
                s = s + seq[i];
                s = s+ " ";
            }
        }
        
        if(s.length()==0)
            return s;
        else
            s = s.substring(0,s.length()-1);
        return s;
    }
}