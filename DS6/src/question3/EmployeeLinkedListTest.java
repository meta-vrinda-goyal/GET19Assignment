package question3;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeLinkedListTest {

	@Test
	public void LinkedListSortingTest() {
		EmployeeLinkedList list = new EmployeeLinkedList();
		list.insertEmployee(new Employee("employee1", 12, 10000));
		list.insertEmployee(new Employee("employee2", 33, 10000));
		list.insertEmployee(new Employee("employee3", 25, 5000));
		list.insertEmployee(new Employee("employee4", 25, 16000));
		list.insertEmployee(new Employee("employee5", 25, 23000));
		String expected[] = new String[]{"employee5", "employee4", "employee1", "employee2", "employee3"};
		list.quickSort();
		assertArrayEquals(expected, list.getEmplyeeList());
	}
}
