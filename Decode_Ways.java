/*
Decode Ways Total Accepted: 14899 Total Submissions: 92907 My Submissions
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*
State: f[n] means the number of ways decoding the substring from 0 to n
Function: f[n] = f[n - 1] (if it is not 0) + f[n - 2] (if it is 1 or 2 ), otherwise return 0
Initialize:f[0] = 0;
Answer:f[s.length()]
*/

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] f = new int[s.length() + 1];
        f[0] = 1; //Very Important;
        for (int i = 1; i < f.length; i++ ) {
            if (i == 1) {
                if (s.charAt(0) == '0') {
                    return 0;
                } else {
                    f[1] = 1;
                }
            } else {
                if (s.charAt(i - 1) != '0') {
                    f[i] += f[i - 1];
                    if (Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                        f[i] += f[i - 2];
                    }
                } else {
                    
                    if (Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26){
                        f[i] += f[i - 2];
                    }
                }
            }
        }
        
        return f[f.length - 1];
    }
}