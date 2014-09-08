/*
Sort Colors Total Accepted: 22308 Total Submissions: 69564 My Submissions
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        int left = 0; 
        int right = A.length - 1;
        int i = 0;
        while (i <= right) {
            if (A[i] == 0) {
                swap(A, i, left);
                left++;
                i++;
            } else if (A[i] == 1) {
                i++;
            } else {
                swap(A, i, right);
                right--;
            }
        }
        
        return;
    }
    private void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}