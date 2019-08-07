package Question1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Node {
	
	private Node parent;
	private String name;
	private Date date = new Date();
	List<Node> childList = new ArrayList<Node>();
	
	public Node getParent() {
		return parent;
	}

	public Node(Node parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}
}
