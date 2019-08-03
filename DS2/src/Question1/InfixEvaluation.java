package Question1;
import java.util.HashMap;
import java.util.Map;

public class InfixEvaluation {

	private String infixExpression;
	//Stack object for operators
	StackOperations operators = new StackOperations();
	//Stack object for operands
	StackOperations operands = new StackOperations();
	//map for storing precedence of operators
	Map<String, Integer> precedence = new HashMap<String, Integer>();

	public InfixEvaluation(String infixExpression) {
		this.infixExpression = infixExpression;
		int i = 1;
		//precedence of operators
		precedence.put("*", i);
		precedence.put("/", i);
		precedence.put("%", i++);
		precedence.put("-", i);
		precedence.put("+", i++);
		precedence.put("<", i);
		precedence.put("<=", i++);
		precedence.put(">", i);
		precedence.put(">=", i++);
		precedence.put("==", i++);
		precedence.put("!=", i++);
		precedence.put("&&", i++);
		precedence.put("||", i++);
		precedence.put("(", i);
	}

	/**
	 *  method to form stack of operators and operands
	 */
	private void formStack() {
		char ch;
		//initially the token is empty
		String token="";
		//traversing the expression
		for (int i = 0; i < infixExpression.length(); i++) {
			ch = infixExpression.charAt(i);
			//storing character in token till space occurs
			if (ch != ' '){
				token+=ch;
			}
			else{
				//if character is an operand
				if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
					operands.push(token);
				}
				//if token is (
				else if (token.charAt(0) == '('){
					operators.push(token);
				}
				//if token is ) then remove all operators and perform operation on operand
				else if (token.charAt(0) == ')') {
					while (!operators.peek().equals("(")) {
						String result = calculation(operators.pop(), operands.pop(), operands.pop());
						operands.push(result);
					}
					operators.pop();
				}
				//if operator occurs
				else {
					//if operator stack is not empty
					if(!operators.isEmpty()){
						//check precedence
						while (!operators.isEmpty() && precedence.get(operators.peek()) < precedence.get(token)) {
							//perform calculation
							String result = calculation(operators.pop(), operands.pop(), operands.pop());
							operands.push(result);
						}
					}
					//at last push operator in stack
					operators.push(token);	
				}
				//empty token 
				token = "";

			}
		}
	}

	/**
	 * @param operator token
	 * @param operand1 token 2
	 * @param operand2 token 3
	 * @return result after performing operation 
	 */
	private String calculation(String operator, String operand1, String operand2) {
		switch (operator) {
			case "*" :
				return (Integer.parseInt(operand2) * Integer.parseInt(operand1)) + "";
			case "/" :
				//divide by zero error
				if (Integer.parseInt(operand1) == 0)
					throw new AssertionError("Cannot divide by zero");
				return (Integer.parseInt(operand2) / Integer.parseInt(operand1)) + "";
			case "%" :
				return (Integer.parseInt(operand2) % Integer.parseInt(operand1)) + "";
			case "+" :
				return (Integer.parseInt(operand2) + Integer.parseInt(operand1)) + "";
			case "-" :
				return (Integer.parseInt(operand2) - Integer.parseInt(operand1)) + "";
			case "<" :
				return (Integer.parseInt(operand2) < Integer.parseInt(operand1)) + "";
			case ">" :
				return (Integer.parseInt(operand2) > Integer.parseInt(operand1)) + "";
			case ">=" :
				return (Integer.parseInt(operand2) >= Integer.parseInt(operand1)) + "";
			case "<=" :
				return (Integer.parseInt(operand2) <= Integer.parseInt(operand1)) + "";
			case "==" :
				return (Integer.parseInt(operand2) == Integer.parseInt(operand1)) + "";
			case "!=" :
				return (Boolean.parseBoolean(operand2) != Boolean.parseBoolean(operand1)) + "";
			case "&&" :
				return (Boolean.parseBoolean(operand2) && Boolean.parseBoolean(operand1)) + "";
			case "||" :
				return (Boolean.parseBoolean(operand2) || Boolean.parseBoolean(operand1)) + "";
			default :
				return "";
		}
	}

	/** 
	 * @return result after evaluation of infix string
	 */
	public String evaluate() {
		//method call to form stack
		formStack();
		//while operator stack is not empty
		while (!operators.isEmpty()) {
			String result = calculation(operators.pop(), operands.pop(), operands.pop());
			operands.push(result);
		}
		//return result
		return operands.pop();
	}
}
