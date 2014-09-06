/*
ZigZag Conversion Total Accepted: 12267 Total Submissions: 51465 My Submissions
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/


public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows < 1 ) {
            return "";
        }
        
        if (nRows == 1) {
            return s;
        }
        
        String[] map = new String[nRows];
        for (int i = 0; i < map.length; i++) {
            map[i] = "";
        }
        int pattern = nRows * 2 - 2;
        for (int i = 0; i < s.length(); i++) {
            int pos = i % pattern;
            if (pos < nRows - 1) {
                map[pos] += s.charAt(i);
            } else {
                map[2 * nRows - 2 - pos] += s.charAt(i);
            }
        }
        String result = "";
        for (int i = 0; i < map.length; i++) {
            result += map[i];
        }
        
        return result;
    }
}