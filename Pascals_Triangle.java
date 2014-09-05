/*
Pascal's Triangle Total Accepted: 18168 Total Submissions: 57356 My Submissions
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (numRows < 1) {
            
            return result;
        }
        
        for (int i = 0; i < numRows; i++) {
            tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                tmp.add(val);
            }
            if (i != 0) {
                tmp.add(1);
            }
            result.add(tmp);
        }
        
        return result;
    }
}