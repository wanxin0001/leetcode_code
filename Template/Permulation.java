/*Copyright: Xin Wan
-Template for Permutation
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num){
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
				list.remove(list.size() - 1);
			}
		}
	}
}

// For replicate numbers
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