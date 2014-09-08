/*
Combination Sum II Total Accepted: 14211 Total Submissions: 57774 My Submissions
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        
        if (num == null || num.length == 0 || target <= 0) {
            return result;
        }
        
        Arrays.sort(num);
        helper(result, tmp, num, target, 0);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tmp, int[] num, int target, int pos) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        } else if (target < 0) {
            return;
        }
        
        for (int i = pos; i < num.length; i++) {
            tmp.add(num[i]);
            helper(result, tmp, num, target - num[i], i + 1);
            tmp.remove(tmp.size() - 1);
            
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
    }
}