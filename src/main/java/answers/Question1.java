package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		int n = 0;
		
		for(int i=0; i<portfolios.length; i++){
			for(int j=0; j<portfolios.length; j++){
				int merged = portfolios[i] ^ portfolios[j];
				if(merged > n){
					n = merged;
				}
			}
		}
		return n;
	}

}
