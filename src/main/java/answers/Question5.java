package answers;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

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
		
		breakLoop:
		if(output == 0) {
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

			//Set<Integer> shares2 = new HashSet<Integer>();

			for(int s:shares){
				for(int n=0; n<allowedAllocations.length; n++){
					int addedShares = s + allowedAllocations[n];
					if(addedShares == totalValue) {
						output = 3;
						break breakLoop;
					}
					/*if(addedShares < totalValue){
						shares2.add(addedShares);
					}*/
				}
			}

			/*
			for(int s:shares2){
				for(int m=0; m<allowedAllocations.length; m++){
					int addedShares = s + allowedAllocations[m];
					if(addedShares == totalValue) {
						output = 4;
						break breakLoop;
					}
				}
			}*/
		}
		return output;
	}
}
