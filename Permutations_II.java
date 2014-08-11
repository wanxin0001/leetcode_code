/*Permutations II Total Accepted: 8712 Total Submissions: 35317 My Submissions
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        permuteHelper(result, list, num, visited);
        
        return result;
    }
    
    private void permuteHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, boolean[] visited){
        if(list.size() == num.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                list.add(num[i]);
                permuteHelper(result, list, num, visited);
                list.remove(list.size()-1);
                visited[i] = false;
                
                while(i < num.length - 1 && num[i] == num[i+1]){
                    i++;
                }
            }
        }
    }
}