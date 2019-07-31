
public class LinkedList {
	Node head; //head node
	/**
	 * @param list
	 * @param data
	 * @return Linked list with all the data inserted
	 */
	public LinkedList insert(LinkedList list , int data){
		//object of type Node
		Node node = new Node(data);
		//if list is empty
		if (list.head == null){
			list.head = node;
		}
		//finding last node
		else { 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            }
            //inserting node in the last
            last.next = node;
        } 
		//return list
		return list;
	}
	/**
	 * @param list to be printed
	 */
	public void printList(LinkedList list){ 
	     Node currNode = list.head; 
	     // Traverse through the LinkedList 
	     while (currNode != null) { 
	         // Print the data at current node 
	         System.out.print(currNode.data + " "); 
	         // Go to next node 
	         currNode = currNode.next; 
	     } 
	} 
}
