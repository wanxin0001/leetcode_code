/*
Two Sum Total Accepted: 27950 Total Submissions: 151842 My Submissions
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        //Arrays.sort(numbers);  //Notice!!!
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (set.containsKey(target - numbers[i])) {
                result[0] = set.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                if (result[0] > result[1]) {
                    int tmp = result[0];
                    result[0] = result[1];
                    result[1] = tmp;
                }
               
                return result;
            } else {
                set.put(numbers[i], i);
            }
        }
        return result;
    }
}