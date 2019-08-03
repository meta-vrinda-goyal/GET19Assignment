package Question3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OrganicChemistry {

	//map for molecules mass
	Map<Character, Integer> molecules = new HashMap<Character, Integer>();
	//stack for compound
	Stack<String> stack = new Stack<String>();

	public OrganicChemistry() {
		//put mass of molecules
		molecules.put('C', 12);
		molecules.put('O', 16);
		molecules.put('H', 1);
	}
	/**
	 * @param compound for mass calculation
	 * @return mass of compound
	 */
	public int calculateCompoundMass(String compound) {
		compound = compound.toUpperCase();
		int compoundmMass = 0;
		char ch;
		for (int i = 0; i < compound.length(); i++) {
			//get character from compound string
			ch = compound.charAt(i);
			//if character is a molecule
			if (molecules.keySet().contains(ch)){
				//put mass of molecule in stack
				stack.push(molecules.get(ch).toString());
			}
			//if character is a digit
			else if (Character.isDigit(ch)) {
				int value = 0;
				//add value till molecule occur
				while (Character.isDigit(ch)) {
					value = value * 10 + Character.getNumericValue(ch);
					i++;
					if(i < compound.length()){
						//get next character of compound string
						ch = compound.charAt(i);
					}
					else{
						break;
					}
				}
				i--;
				//push mass of molecule
				stack.push((Integer.parseInt(stack.pop()) * value) + "");
			} 
			else if (ch == '('){
				//if character is open parenthesis
				stack.push(ch + "");
			}
			//if character is close parenthesis
			else if (ch == ')') {
				int sum = 0;
				String popped = stack.pop();
				//pop value till open parenthesis occur
				while (!popped.equals("(")) {
					//add value
					sum += Integer.parseInt(popped);
					popped = stack.pop();
				}
				//push sum in stack
				stack.push(sum + "");
			}else{
				throw new AssertionError("invalid compound");
			}
		}
		//create compound mass
		while (!stack.isEmpty()) {
			compoundmMass += Integer.parseInt(stack.pop());
		}
		//return compound mass 
		return compoundmMass;
	}
}
