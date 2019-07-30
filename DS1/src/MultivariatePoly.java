import java.util.*; 
/**
 * @author Vrinda
 *
 */
public class MultivariatePoly { 
	//nested list to form multivariate polynomial
	ArrayList<ArrayList<Integer>> listPoly = new ArrayList<ArrayList<Integer>>();
	/**
	 * @param n number of terms
	 * @param terms list of terms
	 */
	public void formPoly(int n,List<Integer> terms){
		int j = 0;
		// traversing the list for total numbers of terms
		for (int i = 0; i<n; i++){
			//form list for getting each term
			ArrayList<Integer> term = new ArrayList<Integer>(); 
			//first term will degree of x, second: degree of y, third:degree of z, fourth: coefficient
			 for(int k = 0; k<4; k++){
				 term.add(terms.get(j));
				 j++;
			 }
			 //add whole term to nested list
			 listPoly.add(term);
		}
		
	}
	
	/**
	 * @return degree of Polynomial
	 */
	public int findDegree(){
		//set degree to 0
		int degree = 0;
		//traverse through each term
		for(int i = 0; i < listPoly.size(); i++){
			//store degree of term in sum
			int sum = 0;
			for(int j = 0; j < 3; j++){
				if(listPoly.get(i).get(3)!=0){
				    sum += listPoly.get(i).get(j);
				}
			}
			//if degree of term is greater than max degree then update degree
			if (sum >= degree){
				degree = sum;
			}
		}
		//return degree
		return degree;
	}
	
	/**
	 *  function to print polynomial
	 */
	public void printPoly(){
		for (int i = 0; i < listPoly.size(); i++) { 
		    for (int j = 0; j < listPoly.get(i).size(); j++) { 
			    System.out.print(listPoly.get(i).get(j) + " "); 
		    } 
		System.out.println(); 
	    } 
	}


} 
