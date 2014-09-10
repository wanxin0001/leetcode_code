/*
Add Binary Total Accepted: 16474 Total Submissions: 63343 My Submissions
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/


public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        
        if (b == null || b.length() == 0) {
            return a;
        }
        
        int len = Math.max(a.length(), b.length()) + 1;
        int[] array = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            int val = count;
            if (i < a.length()) {
                val += Integer.parseInt(a.substring(a.length() - i - 1, a.length() - i));
            }
            if (i < b.length()) {
                val += Integer.parseInt(b.substring(b.length() - i - 1, b.length() - i));
            }
            
            if (val / 2 == 1) {
                count = 1;
                val = val % 2;
            } else {
                count = 0;
            }
            array[i] = val;
        }
        
        StringBuilder str = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            str.append(array[i]);
            
        }
        if (str.charAt(0) == '0') {
            str.delete(0, 1);
        }
        return str.toString();
    }
}