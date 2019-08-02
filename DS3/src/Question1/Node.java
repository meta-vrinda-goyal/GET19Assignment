package Question1;
import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private Node parent;
	private String name;
	List<Node> childList =new ArrayList<Node>();
	
	public Node(Node parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	

	

}
