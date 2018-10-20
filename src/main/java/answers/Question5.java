package answers;

import java.util.Arrays;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		Arrays.sort(allowedAllocations);
		
		int output = 0;
		
		for(int i=0; i<allowedAllocations.length; i++) {
			if(totalValue == allowedAllocations[i]) {
				output = 1;
			}
			else {
				breakLoop:
				for(int k=0; k<allowedAllocations.length; k++){
					for(int j=0; j<allowedAllocations.length; j++){
						output = 2;
						if(allowedAllocations[k] + allowedAllocations[j] == totalValue) {
							break breakLoop;
						}
					}
				}
			}
		}
		return output;
	}

}
