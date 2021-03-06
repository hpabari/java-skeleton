package answers;

import java.util.*;

public class Question2 {

	public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {
		int in = cashflowIn.length;
		int out = cashflowOut.length;
		int output = 0;

		//find all subsets in cashFlowIn, add the values and save in array
		int[] inSet = new int[(int)Math.pow(2, in)];

		for (int i = 0; i < (1<<in); i++){
		    output = 0;
		    for (int j = 0; j < in; j++){ 
				if ((i & (1 << j)) > 0){
					output += cashflowIn[j];
				}
		    }
		    inSet[i] = output;
		}

		//find all subsets in cashFlowOut, add the values and save in array
		int[] outSet = new int[(int)Math.pow(2, out)];

		for (int i = 0; i < (1 << out); i++){
		    output = 0;
		    for (int j = 0; j < out; j++){ 
				if ((i & (1 << j)) > 0){
					output += cashflowOut[j];
				}
		    }
		    outSet[i] = output;
		}

		Arrays.sort(inSet);
		Arrays.sort(outSet);

		//find largest common value in the arrays
		int inflow = 0;
		int outflow = 0;

		for(int k=1; k < inSet.length; k++){
		    for(int m=1; m < outSet.length; m++){
				if(inSet[k] == outSet[m]){
					inflow = inSet[k];
					outflow = outSet[m];
				}
		    }
		}
		
		if((inflow != 0) && (outflow != 0)){
			return inflow - outflow;
		}

		Set<Integer> diffSet = new HashSet<>();

		//if both are empty, sort the cash flow in array and use the smallest value
		if((inflow == 0) && (outflow == 0)){
			diffSet.add(inSet[1] - outflow);

		    for(int p=(inSet.length - 1); p > 0; p--){
			inflow = inSet[p];
				for(int q=(outSet.length - 1); q > 0 ; q--){
					outflow = outSet[q];
					if(inflow > outflow){
						diffSet.add(inflow - outflow);
					}
				}
		    }
		}
		return Collections.min(diffSet);
	}
}
