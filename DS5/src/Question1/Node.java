package Question1;

public class Node{
	private DataEntry entry;
	private Node lChild, rChild;
	
	public Node(DataEntry dataEntry){
		this.entry = dataEntry;
		this.lChild = null;
		this.rChild = null;
	}	
	public void setEntry(DataEntry entry) {
		this.entry = entry;
	}
	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}
	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}
	
    public DataEntry getEntry() {
		return entry;
	}
    public Node getlChild() {
		return lChild;
	}
    public Node getrChild() {
		return rChild;
	}

}

