package Question2;
public class InsertionSort {
	//prev node to get previous node of current
	//current node to point current node in sorted list
	//compare node to point to node to be compared
	//end node to point ending node of sorted list 
	//make end node as starting node initially
	private Node prev,current,compare,end;
	/**
	 * @param list to be sorted
	 * @param size of list
	 * @return
	 */
	public EmployeeLinkedList sort(EmployeeLinkedList list,int size) {
		
		end = list.head.next;
		//outer loop 
		for(int i = 1; i<size; i++) {
			//previous = head
		    prev = list.head;
		    //current = first element of list
			current =  list.head.next;
			//inner loop
			for(int j = 0; j<i; j++) {
				//node to be compared
		        compare = end.next;
		        //if salary is less no need to insert that element in sorted list
				if(compare.employee.getSalary() < current.employee.getSalary()) {
					//shift compare and previous
					caseOfNotInserting(list);
					if(j == i-1)
				    end = end.next;

				}
				//else put element in sorted list
				else if(compare.employee.getSalary() > current.employee.getSalary()) {
					caseOfInserting(list);
					break;
				}
				//if salary of both are equal
				else {
					if(compare.employee.getAge() > current.employee.getAge()) {
						caseOfNotInserting(list);
						if(j == i-1)
						end = end.next;

					}
					else{
						caseOfInserting(list);
						break;
					}
				}
			}
			list.last = end;
		}
		return list;
		
	}
	/**
	 * when element does not need to be inserted
	 */
	private void caseOfNotInserting(EmployeeLinkedList list){
		current = current.next;
		prev = prev.next;
	}
	/**
	 * method when element need to be inserted in sorted list
	 * @param list 
	 */
	private void caseOfInserting(EmployeeLinkedList list){
		if(prev==list.head) {
			list.head.next = compare;
		}
		prev.next = compare;
		Node temp = compare.next;
		compare.next = current;
		end.next = temp;
	}
}
