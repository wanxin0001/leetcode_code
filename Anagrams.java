/*
Anagrams Total Accepted: 14944 Total Submissions: 63059 My Submissions
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs.length == 0) {
            return result;
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            char[] array = cur.toCharArray();
            Arrays.sort(array);
            String newCur = new String(array);
            
            if (!map.containsKey(newCur)) {
                
                map.put(newCur,new ArrayList<String>());
                map.get(newCur).add(cur);
            } else {
                map.get(newCur).add(cur);
            }
        }
        
        for (ArrayList<String> item : map.values()) {
            if (item.size() > 1) {
                result.addAll(new ArrayList<String>(item));
            }
        }
        
        return result;
    }
}