/*
 Binary Search Template
 Give an integer array, search a target number in it, return -1 if it doesn't exit or return the index of this nubmer otherwise.

*/

 public class Soluction {
 	public int binarySearch(int[], int target) {
 		if (A == null || A.length == 0) {
 			return -1;
 		}

 		int start = 0;
 		int end = A.length - 1;
 		int mid;

 		while (start + 1 < end) {
 			mid = start + (end - start) / 2;
 			if ( A[mid] == target) {
 				return mid;
 			} else if (A[mid] < target){
 				start = mid;
 			} else {
 				end = mid;
 			}

 		}

 		if (A[start] == target) {
 			return start;
 		}
 		if (A[end] == target) {
 			return end;
 		}

 		return -1;
 	}
 }