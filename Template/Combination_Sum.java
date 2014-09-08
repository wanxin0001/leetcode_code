/*
Combination Sum Total Accepted: 17959 Total Submissions: 67529 My Submissions
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        helper(result, tmp, candidates, target, 0);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int pos) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        } else if (target < 0) {
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(result, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}