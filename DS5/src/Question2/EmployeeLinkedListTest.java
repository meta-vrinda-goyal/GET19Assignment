package Question2;

import org.junit.Test;

public class EmployeeLinkedListTest {

	@Test
	public void LinkedListSortingTest() {
		EmployeeLinkedList list = new EmployeeLinkedList();
	    list.insertEmployee(new Employee("abc", 12, 13));
	    list.insertEmployee(new Employee("def", 33, 13));
	    list.insertEmployee(new Employee("vfrf", 25, 50));
	    InsertionSort sort = new InsertionSort();
	    sort.sort(list,list.size);
	    list.print();
	}
}
