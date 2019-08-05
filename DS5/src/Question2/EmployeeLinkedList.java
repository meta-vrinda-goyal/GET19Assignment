package Question2;
public class EmployeeLinkedList {
	//head node to point to first element 
	public Node head =  new Node(null);
	//last node to point to last element
	public Node last;
	public int size = 0; 
	public EmployeeLinkedList() {
		this.last = null;
	}
	
	/**
	 * @param employee inserted in linkedList
	 */
	public void insertEmployee(Employee employee) {
		Node newNode = new Node(employee);
		//if list is empty
		if(last == null) {
			head.next = newNode;
			last = newNode;
		}
		//enter employee at last index
		else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}
	/**
	 * method to print list
	 */
	public void print() {
		Node curr = head.next;
		while (curr != null) {
			System.out.println(curr.employee.getName());
			curr = curr.next;
		}
	}
	
	
}
