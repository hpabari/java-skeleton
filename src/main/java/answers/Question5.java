package answers;

import java.util.Arrays;
import java.util.ArrayList;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		
		ArrayList<ArrayList<Integer>> allCombinations = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> workingArray = new ArrayList<Integer>();
		
		Arrays.sort(allowedAllocations);

		getAllCombinations(allowedAllocations, totalValue, workingArray, allCombinations);
	 
		int output = 0;

		if(!allCombinations.isEmpty()){
			output = allCombinations.get(0).size();
			for(int i=0; i<allCombinations.size(); i++){
				if(allCombinations.get(i).size() < output){
					output = allCombinations.get(i).size();
				}
			}
		}
		return output;
	}

	public static void getAllCombinations(int[] allowedAllocations, int totalValue, ArrayList<Integer> workingArr, ArrayList<ArrayList<Integer>> allCombinations){
		
		if(totalValue == 0){
			ArrayList<Integer> temp = new ArrayList<Integer>(workingArr);
			allCombinations.add(temp);
			return;
		}
		
		for(int i=0; i<allowedAllocations.length; i++){
			if(totalValue < allowedAllocations[i]){
				return;
			}
			workingArr.add(allowedAllocations[i]);
			getAllCombinations(allowedAllocations, totalValue - allowedAllocations[i], workingArr, allCombinations);
			workingArr.remove(workingArr.size()-1);
		}
	}
}
