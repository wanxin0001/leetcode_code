/*Combination Sum Total Accepted: 9870 Total Submissions: 37785 My Submissions
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


//Note: we need the pos in combinationHelper(). It is because that The same repeated number may be chosen from C unlimited number of times. Otherwise, it cannot obey the non-descending order.

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target <=0 || candidates.length == 0 || candidates == null){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationHelper(result, list, candidates, target, 0);
        
        return result;
    }
    
    private void combinationHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] candidates, int target, int pos){
        if (target == 0){
            result.add(new ArrayList<Integer>(list));
        }
        else if (target < 0){
            return;
        }
        
        for (int i = pos; i < candidates.length; i++){
            list.add(candidates[i]);
            combinationHelper(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}