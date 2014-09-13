/*
4Sum Total Accepted: 14300 Total Submissions: 66273 My Submissions
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length <= 3) {
            return result;
        }
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int first = num[i];
                int second = num[j];
                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = first + second + num[left] + num[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(first);
                        tmp.add(second);
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        result.add(tmp);
                        left++;
                        right--;
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                        
                    }
                }
                
                while (j < num.length - 3 && num[j] == num[j + 1]) {
                    j++;
                }
            }
            
            while (i < num.length - 4 && num[i] == num[i + 1]) {
                i++;
            }
        }
        
        return result;
    }
}