/*
Search for a Range Total Accepted: 15945 Total Submissions: 58363 My Submissions
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        if (A.length == 0) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        
        int start, end, mid;
        start = 0;
        end = A.length -1;
        
        //for the start side
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            }
            else if (A[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        if (A[start] == target) {
            result[0] = start;
        }
        else if (A[end] == target) {
            result[0] = end;
        }
        else {
            result[0] = result[1] = -1;
            return result;
        }
        
        //For the end side
        start = 0; //NOTICE!!!
        end = A.length -1;//NOTICE!!!
        while(start < end - 1) {
            mid = start + (end - start) / 2;
            if(A[mid] == target) {
                start = mid;
            }
            else if(A[mid] < target) {
                start = mid  + 1;
            }
            else {
                end = mid -1;
            }
        }
        
        if (A[end] == target) {
            result[1] = end;
        }
        else if (A[start] == target) {
            result[1] = start;
        }
        else {
            result[0] = result[1] = -1;
            return result;
        }
        
        return result;
    }
}