/*
Word Ladder Total Accepted: 17639 Total Submissions: 96413 My Submissions
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || start.length() == 0 || end == null || end.length() == 0 || dict.size() == 0) {
            return 0;
        }
        
        dict.remove(start);
        
        
        
        ArrayList<String> list = new ArrayList<String>();
        for (String item : dict) {
            list.add(item);
        }
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int sublen = list.size();
                for (int j = 0; j < list.size(); j++) {
                    if (isValid(cur, list.get(j))) {
                        if (list.get(j).equals(end)) {
                            return len + 2;
                        }
                        queue.offer(list.get(j));
                        list.remove(j);
                        j--;
                    }
                }
            }
            len++;
        }
    
        return 0;
    }
    
    private boolean isValid(String cur, String goal) {
        int size = 0;
        for (int i = 0; i < cur.length(); i++ ) {
            if (cur.charAt(i) != goal.charAt(i)) {
                size++;
            }
            if (size > 1) {
                return false;
            }
        }
        if (size == 1) 
            return true;
        return false;
    }
}