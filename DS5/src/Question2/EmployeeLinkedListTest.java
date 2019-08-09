package Question2;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class EmployeeLinkedListTest {

	@Test
	public void LinkedListSortingTest() {
	    EmployeeLinkedList list = new EmployeeLinkedList();
	    list.insertEmployee(new Employee("abc", 12, 13));
	    list.insertEmployee(new Employee("def", 33, 13));
	    list.insertEmployee(new Employee("vfrf", 25, 50));
	    InsertionSort sort = new InsertionSort();
	    String arr[] = new String[]{"vrinda","abc","def"};
	    list = sort.sort(list,list.size);
	    String arr2 [] = list.print();
	    assertArrayEquals(arr,arr2);
	}
}
