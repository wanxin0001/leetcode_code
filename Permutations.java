/*
 Permutations Total Accepted: 12836 Total Submissions: 41675 My Submissions
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        permuteHelper(result, list, num);
        
        return result;
    }
    
    private void permuteHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num){
        if(list.size() == num.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if(!list.contains(num[i])){
                list.add(num[i]);
                permuteHelper(result, list, num);
                list.remove(list.size()-1);
            }
        }
    }
}