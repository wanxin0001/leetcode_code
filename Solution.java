public class Solution {
    public static void main(String[] argv) {
        String s = "1.1";

        Solution obj = new Solution();
        if(obj.isNumber(s)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public boolean isNumber(String s) {
        s = s.trim(); // should be first
        if (s == null || s.length() == 0) {
            return false;
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

        String[] items = s.split("\\e", -1); 
        System.out.println(s);
        System.out.println(items.length);
         //System.out.println(items[0]);
         //System.out.println(items[1]);
         //System.out.println(items[2]);
        if (items.length == 2  && !items[1].equals("")) { // not items[0] == null
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
            if ((isDecimal(items[0]) || isInteger(items[0])) && isInteger(items[1])) {
                return true;
            }
            return false;
        }
        
        return false;
    }
}