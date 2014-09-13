/*
Next Permutation Total Accepted: 15328 Total Submissions: 60458 My Submissions
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        
        for (int i = num.length - 2; i >=0; i--) {
            if (num[i] < num[i + 1]) {
                int j;
                for (j = num.length - 1; j >= i + 1; j--) {
                    if (num[j] > num[i]) {
                        break;
                    }
                }
                
                swap(num, i, j);
                reverse(num, i + 1, num.length - 1);
                return;//Need
            }
        }
        
        reverse(num, 0, num.length - 1); //Need;
    }
    
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i++;
            j--;
        }
    }
}