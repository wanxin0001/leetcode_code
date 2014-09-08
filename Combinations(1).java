/*
Combinations Total Accepted: 19089 Total Submissions: 62850 My Submissions
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
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        
        helper(result, tmp, n, k, 1);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tmp, int n, int k,  int pos) {
        if (tmp.size() == k ) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        else {
            for (int i = pos; i <= n; i++) {
                
                    tmp.add(i);
                    helper(result, tmp, n, k, i + 1);//must be i, rather than pos !!!
                    tmp.remove(tmp.size() - 1);
                
            }
        }
    }


}

