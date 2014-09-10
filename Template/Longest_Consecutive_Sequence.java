/*
Longest Consecutive Sequence Total Accepted: 19473 Total Submissions: 69329 My Submissions
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }   
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        
        int maxSize = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> itr = set.iterator();
            int elem = itr.next();
            int size = maxSize(elem, set);
            maxSize = Math.max(maxSize, size);
        }
        
        return maxSize;
    }
    
    private int maxSize(int elem, HashSet<Integer> set) {
        int size = 1;
        set.remove(elem);
        int curVal = elem;
        curVal--;
        while(!set.isEmpty() && set.contains(curVal)) {
            set.remove(curVal);
            size++;
            curVal--;
        }
        curVal = elem + 1;
        while (!set.isEmpty() && set.contains(curVal)) {
            set.remove(curVal);
            size++;
            curVal++;
        }
        
        return size;
    }
}