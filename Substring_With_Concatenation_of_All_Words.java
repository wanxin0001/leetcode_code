/*
Substring with Concatenation of All Words Total Accepted: 12577 Total Submissions: 69771 My Submissions
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
*/

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (S == null || S.length() == 0 || L.length == 0) {
            return result;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashSet<String> resultSet = new HashSet<String>();
        HashSet<String> nonResultSet = new HashSet<String>();
        
        int wordLen = L[0].length();
        int totalSize = wordLen * L.length;
        for (int i = 0; i <= S.length() - totalSize; i++) {
            if (resultSet.contains(S.substring(i, i + totalSize))) {
                result.add(i);
                continue;
            }
            if (nonResultSet.contains(S.substring(i, i + totalSize))) {
                
                continue;
            }
            map.clear();
            for (int j = 0; j < L.length; j++) {
                if (map.containsKey(L[j])) {
                    map.put(L[j], map.get(L[j]) + 1);
                } else {
                    map.put(L[j], 1);
                }
            }
            if (helper(S.substring(i, i + totalSize), map, wordLen, L.length) ){
                result.add(i);
                resultSet.add(S.substring(i, i + totalSize));
            } else {
                nonResultSet.add(S.substring(i, i + totalSize));   
            }
        
        }
        
        return result;
    }
    
    private boolean helper(String S, HashMap<String, Integer> map, int wordLen, int size) {
        for (int i = 0; i < size; i++) {
            String cur = S.substring(wordLen * i, wordLen * (i + 1));
            if (map.containsKey(cur)) {
                if (map.get(cur) != 0) {
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0) {
                        map.remove(cur);   
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (map.size() == 0) {
         return true;
        }
        return false;
    }
}