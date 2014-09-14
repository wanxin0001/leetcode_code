/*
Longest Substring Without Repeating Characters Total Accepted: 22717 Total Submissions: 101705 My Submissions
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++ ) {
            set.add(s.charAt(i));
        }
        if (set.size() <= 2) {
            return set.size();
        }
        int size = set.size();
        set.clear();
        
       // s = s.toLowerCase();
        
        int left = 0;
        int max = 1;
        int[] flag = new int[256];
        for (int i = 0; i < 256; i++) {
            flag[i] = -1;
        }
        for (int i = 0; i < s.length(); i++ ) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                flag[s.charAt(i) ] = i;
                continue;
            } else {
                max = Math.max(max, set.size());
                if (max == size) {
                    return size;
                }
                int next = flag[s.charAt(i) ] + 1;
                for (int j = left; j < next; j++) {
                    //flag[s.charAt(j)] = -1;
                    set.remove(s.charAt(j));
                    
                }
                left = next;
                set.add(s.charAt(i));
                flag[s.charAt(i)] = i;
            }
        }
        
        max = Math.max(max, set.size());
        return max;
    }
}