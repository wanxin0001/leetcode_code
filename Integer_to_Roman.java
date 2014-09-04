/*
Integer to Roman Total Accepted: 13648 Total Submissions: 40604 My Submissions
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        int[] array =  {1, 4, 5, 9, 10, 40, 50, 90,  100, 400, 500, 900, 1000};
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        String result = "";
        for (int i = array.length - 1; i >=0; i--) {
            while (num >= array[i]) {
                result += map.get(array[i]);
                num -= array[i];
            } 
                
            if (num == 0) {
                break;
            }
        }
        
        return result;
    }
}