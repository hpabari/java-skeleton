package answers;

import java.util.Set;
import java.util.HashSet;

public class Question6 {

	public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
		Set <Integer> routes = new HashSet<>();
		routes.add(times[0][targetServer]);
		
		for(int j=0; j<numServers; j++){
			if(j != targetServer){
				int otherServer = times[0][j];
				routes.add(otherServer + times[j][targetServer]);
			}
		}

		int output = Collections.min(routes);
	
		return output;
	}

}
