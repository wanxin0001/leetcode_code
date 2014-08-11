/*Copyright: Xin Wan
-Template for combination
*/

public class Solution{
	public ArrayList<ArrayList<Integer>> subsets(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		subsetsHelper(result, list, num, 0);

		return result;
	}	

	private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int pos){
		
		result.add(new ArrayList<Integer>(list));

		for(int i = pos; i < num.length; i++){

			list.add(num[i]);
			subsetsHelper(result, list, num, i+1); //Note: it is i+1, not pos+1
			list.remove(list.size()-1);
		}
	}
}

/* Template II
   If there contains duplicates, the solution is as follows:
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);
        
        return result;
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int pos){
        result.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < num.length; i++){
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
            
            while(i < num.length - 1 && num[i] == num[i + 1]){  //new add
                i++;	//new add
            }
        }
    }
}