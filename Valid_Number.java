/* 
Valid Number Total Accepted: 10756 Total Submissions: 97742 My Submissions
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); // should be first
        
        if (s == null || s.length() == 0) {
            return false;
        }
        
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        
        if(isInteger(s)) {
            return true;
        }
        if (isDecimal(s)) {
            return true;
        }
        if (isExp(s)) {
            return true;
        }
        
        return false;
        
        
    }
    
    private boolean isInteger(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isDecimal(String s) {
        String[] items = s.split("\\.", -1); 
        if (items.length == 2  && (!items[1].equals("") || !items[0].equals(""))) { // not items[0] == null
            if (isInteger(items[0])  && isInteger(items[1])) {
                return true;
            }
            return false;
        }
        
        return false;
        
    }
    
    private boolean isExp(String s) {
        String[] items = s.split("e", -1); // must be "e", rather than 'e'
        if (items.length == 2 && !items[0].equals("") && !items[1].equals("")) { // not items[0] == null
            if (items[1].charAt(0) == '-' || items[1].charAt(0) == '+') {
                items[1] = items[1].substring(1);
            }
            if ((isDecimal(items[0]) || isInteger(items[0])) && isInteger(items[1]) && items[1].length() != 0) {
                return true;
            }
            return false;
        }
        
        return false;
    }
}
