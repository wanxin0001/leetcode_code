public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int size = 0;
        int cur = x;
        while (cur != 0) {
            size++;
            cur /= 10;
        }
        
         long origin = (long) x;
         long now = 0;
         while (size > 0) {
             size--;
             long val = origin % 10; //not int
             now = now * 10 + val;
             origin = origin / 10;
             
         }
         System.out.println(now + " " + origin);
         if (now == origin) {
             return true;
         } else {
             return false;
         }
         
    }
    public static void main(String[] str) {
        Solution obj = new Solution();
        if (obj.isPalindrome(1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}