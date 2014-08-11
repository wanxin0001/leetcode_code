/*
Search in Rotated Sorted Array II Total Accepted: 13629 Total Submissions: 44538 My Submissions
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
public class Solution {
    public boolean search(int[] A, int target) {
        if (A.length == 0 || A == null) {
            return false;
        }
        int start, end, mid;
        start = 0;
        end = A.length - 1;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            }
            else if (A[start] < A[mid]) {
                if (A[start] <= target && target < A[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else if (A[start] > A[mid]) {
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            else {
                start++;
                
            }
        }
        
        if (A[start] == target) {
            return true;
        }
        if (A[end] == target) {
            return true;
        }
        
        return false;
    }
}