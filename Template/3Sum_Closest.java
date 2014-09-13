/*
3Sum Closest Total Accepted: 16080 Total Submissions: 59221 My Submissions
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length <= 2) {
            return 0;
        }
        
        int diff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                int difference = Math.abs(sum - target);
                if (difference == 0) {
                    return target;
                } else {
                    if (diff > difference) {
                        diff = difference;
                        result =sum;
                    }
                    if (sum < target) {
                        left++;
                        
                    } else {
                        right--;
                    }
                    
                }
                /*
                left++;
                right--;
                while (left < right && num[left] == num[left - 1]) {
                    left++;
                }
                
                while (left < right && num[right] == num[right + 1]) {
                    right--;
                }
                */
                
            }
            
            while (i < num.length - 3 && num[i] == num[i + 1]) {
                i++;
            }
        }
        
        return result;
    }
}