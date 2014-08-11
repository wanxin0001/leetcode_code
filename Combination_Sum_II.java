/*Combination Sum II Total Accepted: 7624 Total Submissions: 31917 My Submissions
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
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0 || target <= 0){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        combinationHelper(result, list, num, target, 0);
        
        return result;
    }
    
    private void combinationHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int target, int pos){
        if (target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        else if ( target < 0){
            return;
        }
        
        for(int i = pos; i < num.length; i++){
            list.add(num[i]);
            combinationHelper(result, list, num, target - num[i], i + 1);   // Note: it's i, not pos
            list.remove(list.size()-1);
            
            while(i < num.length - 1 && num[i] == num[i + 1]){
                i++;
            }
        }
        
    }
}