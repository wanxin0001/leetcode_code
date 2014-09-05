/*
Pascal's Triangle II Total Accepted: 16147 Total Submissions: 53015 My Submissions
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                int val = result.get(j) + result.get(j - 1);
                result.set(j, val);
            }
            result.add(1);
        }
        
        return result;
    }
}