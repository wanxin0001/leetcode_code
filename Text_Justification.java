/*
Text Justification Total Accepted: 8582 Total Submissions: 61061 My Submissions
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
*/

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 0 || L == 0) {
            result.add("");
            return result;
        }
        
        ArrayList<ArrayList<String>> wordsList = new ArrayList<ArrayList<String>>();
        divide(wordsList, words, L);
        print(result, wordsList, L);
        
        return result;
    }
    
    private void divide(ArrayList<ArrayList<String>> wordsList, String[] words, int L) {
        int len = 0;
        ArrayList<String> tmp = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (len == 0) {
                len += words[i].length();
            } else {
                len += words[i].length() + 1;
            }
            if (len <= L) {
                tmp.add(words[i]);
                
            } else {
                i--;
                wordsList.add(new ArrayList<String>(tmp));
                len = 0;
                tmp.clear();
            }
        }
        if (tmp.size() != 0 ) {
            wordsList.add(tmp);
        }
        return;
    }
    
    private void print(List<String> result, ArrayList<ArrayList<String>> wordsList, int L) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            printLine(result, wordsList.get(i), L);
        }
        String line = "";
        for (int i = 0; i < wordsList.get(wordsList.size() - 1).size(); i++) {
            line += wordsList.get(wordsList.size() - 1).get(i) + " ";
        } 
        
        int size = L - line.length();
        for (int i = 0; i < size; i++) {
            line += " ";
        }
        result.add(line.substring(0, L));
    }
    
    private void printLine(List<String> result, ArrayList<String> words, int L) {
        int size = words.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += words.get(i).length();
        }
        
        String resultWord = "";
        
        
        
        if (size == 1) {
            resultWord = words.get(0);
            int size1 = L - resultWord.length();
            for(int i = 0; i < size1; i++) {
                resultWord += " ";
            }
            
            result.add(resultWord);
        } else {
            int interval = (L - length) / (size - 1);
            if ((L - length) % (size - 1) == 0) {
                String space = "";
                for (int i = 0; i < interval; i++) {
                    space += " ";
                }
                for (int i = 0; i < words.size(); i++) {
                    resultWord += words.get(i) + space;
                }
                
                result.add(resultWord.substring(0, L));
            } else {
                int num  = (L - length) % (size - 1);
                String space = "";
                for (int i = 0; i < interval; i++) {
                    space += " ";
                }
                for (int i = 0; i < words.size(); i++) {
                    if (i < num) {
                        resultWord += words.get(i) + space + " ";
                    } else {
                        resultWord += words.get(i) + space;   
                    }
                }
                
                result.add(resultWord.substring(0, L));
            }
        }
    }
}