/*
Gray Code Total Accepted: 15911 Total Submissions: 49669 My Submissions
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


*/

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 0) {
            result.add(0);
            return result;
        }
        
        int i = 1;
        while (i <= n) {
            helper(result, i);
            i++;
        } 
        return result;
    }
    private void helper(List<Integer> result, int i) {
        if (i == 1) {
            result.add(0);
            result.add(1);
        } else {
            List<Integer> newList = new ArrayList<Integer>(result);
            for (int j = 0; j < result.size(); j++) {
                int val = result.get(result.size() - j - 1) + (int) Math.pow(2, i - 1);
                newList.set(j, val);
            }
            
            result.addAll(newList);
        }
    }
}