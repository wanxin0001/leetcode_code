public class Solution {
    
    public static void main(String[] str) {
        Solution obj = new Solution();
        obj.countAndSay(6);
    }
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = helper(result);
            System.out.println(result);
        }
        
        return result;
    }
    
    private String helper(String input) {
        int last = 0;
        String result = "";
        
        for (int i = 0; i < input.length() ; i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                i++;
            } else {
                result += Integer.toString(i - last + 1) + Character.toString(input.charAt(i));
                System.out.println(result + " " +last +" " + i + "  11");
                last = i + 1;
            }
        }
        
        if (last != input.length()) {
            result += Integer.toString(input.length() - last) + Character.toString(input.charAt(last));
        }
        
        return result;
    }
}