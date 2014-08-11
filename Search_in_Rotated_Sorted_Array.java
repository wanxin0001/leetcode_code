/*
Search in Rotated Sorted Array Total Accepted: 20793 Total Submissions: 72736 My Submissions
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        
        int start, end, mid;
        start = 0;
        end = A.length -1;
        
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            else if (A[start] < A[mid]) {
                if (A[start] <= target && target < A[mid]) {
                    end = mid -1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        
        if (A[start] == target) {//Necessary
            return start;
        }
        else if (A[end] == target) {
            return end;
        }
        else {
            return -1;
        }    
    }
}