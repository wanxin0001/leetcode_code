/*
Minimum Window Substring Total Accepted: 13488 Total Submissions: 74913 My Submissions
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0) {
            return S;
        }
        
        if (T == null || T.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> stringMap = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (stringMap.containsKey(T.charAt(i))) {
                stringMap.put(T.charAt(i), stringMap.get(T.charAt(i)) + 1);
            } else {
                stringMap.put(T.charAt(i), 1);
            }
        }
        
        HashMap<Character, Integer> newMap = new HashMap<Character, Integer>();
        int counter = 0;
        int leftBound = 0;
        String minWindows = "";
        
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (!stringMap.containsKey(c)) {
                continue;
            }
            
            if (newMap.containsKey(c)) {
                newMap.put(S.charAt(i), newMap.get(S.charAt(i)) + 1);
            } else {
                newMap.put(S.charAt(i), 1);
            }
            
            if (newMap.get(c) <= stringMap.get(c)) { // it should be <= because we have alreay added it into newMap
                counter++;
            }
            
            if (counter == T.length()) {
                while (leftBound < i + 1) {
                    Character ch = S.charAt(leftBound);
                    if (!newMap.containsKey(ch)) {
                        leftBound++;
                        continue;
                    }
                    
                    if (newMap.get(ch) > stringMap.get(ch)) {
                        leftBound++;
                        newMap.put(ch, newMap.get(ch) - 1);
                        continue;
                    }
                    
                    break;
                }
                
                if (minWindows.length() == 0) {
                    minWindows = S.substring(leftBound, i + 1);
                } else if (i + 1 - leftBound < minWindows.length()) {
                    minWindows = S.substring(leftBound, i + 1);
                }
            }
            
        }
        
        return minWindows;
    }
}