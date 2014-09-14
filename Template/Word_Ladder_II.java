/*
Word Ladder II Total Accepted: 10751 Total Submissions: 94733 My Submissions
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
          List<List<String>> res = new ArrayList<List<String>>();
          if (start == null || end == null) {
              return res;
          }
          
          ArrayList<String> tmparray = new ArrayList<String>();
          
          if (start.equals(end)) {
              tmparray.add(start);
              tmparray.add(end);
              res.add(tmparray);
              return res;
          }
          
          HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
          map.put(end, new ArrayList<String>());
          map.put(start, new ArrayList<String>());
          for (String s : dict) {
              map.put(s, new ArrayList<String>());
          }
          
          Queue<String> queue = new LinkedList<String>();
          queue.offer(start);
          ArrayList<String> currentLevel = new ArrayList<String>();
          while (!queue.isEmpty() ) {
              int level = queue.size();
              currentLevel.clear();
              for (int i = 0; i < level; i++) {
                  String top = queue.poll();
                  if (dict.contains(top)) {
                      dict.remove(top);
                  }
                  currentLevel.add(top);
              }
              
              for (String curs : currentLevel) {
                  for (int i = 0; i < curs.length(); i++) {
                      for (char j = 'a'; j <= 'z'; j++) {
                          char[] tmpchar = curs.toCharArray();
                          tmpchar[i] = j;
                          String tmps = new String(tmpchar);
                          if (!curs.equals(start) && tmps.equals(end)) {
                              map.get(end).add(curs);
                              queue.offer(tmps);
                          } else if (!tmps.equals(curs) && dict.contains(tmps)) {
                                if (!queue.contains(tmps)) {
                                    queue.offer(tmps);
                                }                     
                                map.get(tmps).add(curs);
                          }
                          
                          
                          
                      }
                      
                      
                  }
                  
              }
              if (queue.contains(end)) {
                              break;
                    }
          }
          
        tmparray.add(end);
        buildpath(start, end, map, tmparray, res);
        return res;
    }
    
    private void buildpath(String start, String end,  HashMap<String, ArrayList<String>> map, ArrayList<String> tmparray, List<List<String>> res) {  
        ArrayList<String> pre = map.get(end);
        if (end.equals(start)) {
            ArrayList<String> tmparray2 = new ArrayList<String>(tmparray);
            Collections.reverse(tmparray2);
            res.add(tmparray2);
            return;
        }
        
        for (String s : pre) {
            tmparray.add(s);
            buildpath(start, s, map, tmparray, res);
            tmparray.remove(tmparray.size() - 1);
        }
    }
}