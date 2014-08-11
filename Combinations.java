/*Combinations Total Accepted: 10604 Total Submissions: 35362 My Submissions
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        combineHelper(result, list, n, k, 0);
        
        return result;
    }
    
    private void combineHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int n, int k, int pos){
        if ( list.size() == k){
            result.add(new ArrayList(list));
            return;
        }
        
        for (int i = pos; i < n; i++){
            list.add(i + 1);
            combineHelper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}