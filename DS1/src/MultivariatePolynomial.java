import java.util.ArrayList;
import java.util.List;

public class MultivariatePolynomial {
	//nested list for degree of multivariate polynomial
	private List<List<Integer>> nestedList = new ArrayList<List<Integer>>();

	public MultivariatePolynomial(String poly) {
		//convert in lower case
		poly = poly.toLowerCase();
		//add operator at last in polynomial
		poly += '+';
		//list for terms of polynomial
		List<String> terms = new ArrayList<String>();
		String termOfpoly = "";
		char ch;
		for (int i = 0; i < poly.length(); i++) {
			//split in terms
			ch = poly.charAt(i);
			if (ch == '+' || ch == '-') {
				terms.add(termOfpoly);
				termOfpoly = "";
			} else
				termOfpoly += ch;
		}
		for (int i = 0; i < terms.size(); i++) {
			//get each term
			termOfpoly = terms.get(i);
			//add a new list in nested list
			nestedList.add(new ArrayList<Integer>());
			for (int j = 0; j < termOfpoly.length(); j++) {
				//get character of term
				ch = termOfpoly.charAt(j);
				//when starting with variable
				if (j == 0 && ch >= 'a' && ch <= 'z') {
					//coefficient of term is 1
					nestedList.get(i).add(1);
				} else if (ch >= '1' && ch <= '9') {
					if(nestedList.get(i).size() >= 1 && (termOfpoly.charAt(j - 1) >= '1' && termOfpoly.charAt(j - 1) <= '9')){
						//get last value
						int previousValue = nestedList.get(i).get(nestedList.get(i).size()-1);
						previousValue = (previousValue * 10) + Character.getNumericValue(ch);
						nestedList.get(i).remove(nestedList.get(i).size()-1);
						//replace new value
						nestedList.get(i).add(previousValue);
					}else{
						nestedList.get(i).add(Character.getNumericValue(ch));
	
					}
					//when character is variable
				} else if (ch >= 'a' && ch <= 'z') {
					if ((j + 1) == termOfpoly.length() || (termOfpoly.charAt(j + 1) >= 'a' && termOfpoly.charAt(j + 1) <= 'z')) {
						nestedList.get(i).add(1);
					}
				} else
					//case of invalid polynomial
					throw new AssertionError("invalid polynomial");
			}
		}
	}

	public int findDegree() {
		// set degree to 0
		int degree = 0;
		// store degree of term in sum
		int sum;
		// traverse through each term
		for (int i = 0; i < nestedList.size(); i++) {
			sum = 0;
			for (int j = 1; j < nestedList.get(i).size(); j++) {
				if (nestedList.get(i).get(0) != 0) {
					sum += nestedList.get(i).get(j);
				}
			}
			// if degree of term is greater than max degree then update degree
			if (sum >= degree) {
				degree = sum;
			}
		}
		// return degree
		return degree;
	}

}
