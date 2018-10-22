package answers;

import java.util.*;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
		
		if((rows[0].length > 100) || (numberMachines > 100)){
			return 0;
		}

		if(rows[0].length < numberMachines){
			return 0;
		}
		
		int repairTime = 0;
		int tracknumber = 0;
		
		Set<Integer> possibleRepairs = new HashSet<Integer>(); 

		for(int i=0; i<rows.length; i++){
			for(int j=0; j<rows[i].length; j++){
				if(!rows[i][j].equals("X")){
					repairTime += Integer.parseInt(rows[i][j]);
					tracknumber++;
					if(tracknumber == numberMachines){
						possibleRepairs.add(repairTime);
					}
				}
				else{
					repairTime = 0;
					tracknumber = 0;
				}
			}
			repairTime = 0;
			tracknumber = 0;
		}
		
		int output = 0;
		
		if(!possibleRepairs.isEmpty()){
			output = Collections.min(possibleRepairs);
		}

		return output;
	}
}
