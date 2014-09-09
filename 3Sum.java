/*
3Sum Total Accepted: 21942 Total Submissions: 130009 My Submissions
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        List<Integer> tmp = new ArrayList<Integer>();
        helper(result, tmp, num, 0, 0);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tmp, int[] num, int pos, int sum) {
        if (tmp.size() == 3 && sum == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        } else if (tmp.size() == 3) {
            return;
        }
        
        for (int i = pos; i < num.length; i++) {
            tmp.add(num[i]);
            helper(result, tmp, num, i + 1, sum - num[i]);
            tmp.remove(tmp.size() - 1);
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
        
    }
}