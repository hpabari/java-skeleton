package answers;

import helpers.Edge;

public class Question3 {

	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
		ArrayList<ArrayList<Integer>> hasRelation= new ArrayList<>();
		ArrayList<Integer> relation;
		for(int j=1; j<=numNodes; j++){
			relation = new ArrayList<>();
			for(int i=0; i<edgeList.length; i++){
				if(edgeList[i].getEdgeA() == j){
					relation.add(edgeList[i].getEdgeB());
				}
				if(edgeList[i].getEdgeB() == j){
					relation.add(edgeList[i].getEdgeA());
				}
			}
			hasRelation.add(relation);
		}

		int leastRel = hasRelation.get(0).size();
		
		for(int k=0; k<hasRelation.size(); k++){
			if(hasRelation.get(k).size() < leastRel){
				leastRel = hasRelation.get(k).size();
			}
		}

		ArrayList<ArrayList<Integer>> leastRelations= new ArrayList<>();
		
		for(int m=0; m<hasRelation.size(); m++){
			if(hasRelation.get(m).size() == leastRel){
				leastRelations.add(hasRelation.get(m));
			}
		}

		int output = leastRelations.size() - (numNodes - leastRelations.size());

		return output;
	}

}
