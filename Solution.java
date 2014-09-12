import java.util.*;

public class Solution {
    public static void main(String[] str) {
        Solution obj = new Solution();
        String[] words = {""};


        obj.fullJustify(words, 2);
    }
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
            len += words[i].length();
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
        for (int i = 0; i < wordsList.size(); i++) {
            printLine(result, wordsList.get(i), L);
        }
        
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
            System.out.println(resultWord.length());
            for(int i = 0; i < L - resultWord.length(); i++) {
                resultWord += " ";
            }
            System.out.println(resultWord+"11");
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