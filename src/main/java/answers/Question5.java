package answers;

import java.util.Arrays;
import java.util.ArrayList;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		
		Arrays.sort(allowedAllocations);
		
		int output = 0;
		
		for(int i=0; i<allowedAllocations.length; i++) {
			if(totalValue == allowedAllocations[i]) {
				output = 1;
			}
		}	
		
		Set<Integer> shares = new HashSet<Integer>();

		while(output == 0) {
			breakLoop:
			for(int k=0; k<allowedAllocations.length; k++){
				for(int j=0; j<allowedAllocations.length; j++){
					int addedShares = allowedAllocations[k] + allowedAllocations[j];
					if(addedShares == totalValue) {
						output = 2;
						break breakLoop;
					}
					if(addedShares < totalValue){
						shares.add(addedShares);
					}
				}
			}

			breakloop2:
			for(int m:shares){
				for(int n=0; n<allowedAllocations.length; n++){
					int addedShares = m + allowedAllocations[n];
					if(addedShares == totalValue) {
						output = 3;
						break breakloop2;
					}
				}
			}
		}
		return output;
	}
}
