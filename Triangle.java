/*
Triangle Total Accepted: 15224 Total Submissions: 56877 My Submissions
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        
        int[] array = new int[triangle.size()];
        array[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) { //Notice: Must be in reversed order
                if (j == 0 ) {
                    array[j] = array[j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) { 
                    array[j] = array[j - 1] + triangle.get(i).get(j); // Notice: it should be j - 1, rather than j
                }
                else {
                    array[j] = triangle.get(i).get(j) + Math.min(array[j - 1], array[j]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        
        return min;
    }
}