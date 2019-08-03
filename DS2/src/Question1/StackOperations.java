package Question1;

import java.util.ArrayList;
import java.util.List;

public class StackOperations implements Stack {
	//list to store tokens
	List<String> stack = new ArrayList<String>();

	@Override
	public void push(String data) {
		//adding data in stack
		stack.add(data);
	}

	@Override
	public String pop() {
		//if stack is not empty
		if (!isEmpty()) {
			//get top element of stack
			String data = stack.get(stack.size() - 1);
			//remove element from stack
			stack.remove(stack.size() - 1);
			return data;
		}
		//if stack is empty
		else{
			throw new AssertionError("operator stack is empty");
		}
	}

	@Override
	public boolean isEmpty() {
		//return true is stack is empty else false
		return stack.isEmpty();
	}

	@Override
	public String peek() {
		//if stack is not empty show top element
		if (!isEmpty()) {
			return stack.get(stack.size() - 1);
		}
		//if stack is empty
		else{
			throw new AssertionError("operator stack is empty");
		}
	}
}
