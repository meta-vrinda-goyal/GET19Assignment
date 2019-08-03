package Question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class EmployeeCollectionTest {

	@Test
	public void SortByNametest() {
		EmployeeCollection collection = new EmployeeCollection();
		collection.addEmployee(10,"Vrinda", "ABC");
		collection.addEmployee(3,"VINI", "ds");
		collection.addEmployee(4,"Sakshi", "SD");
		collection.addEmployee(4,"sachin", "SDC");
		collection.addEmployee(5,"sachin", "SDSC");
		collection.addEmployee(2,"mini", "qwe");
		//making a list
		List<Employee> peopleList = new ArrayList<Employee>();
		//adding employee from set to list
		peopleList.addAll(EmployeeCollection.set);
		//sorting list 
		Collections.sort(peopleList,new  SortByName());
		for (Employee emp : peopleList) {
            System.out.println(emp);
        }
	    System.out.println();
	}
	@Test
	public void SortByIdtest() {
		EmployeeCollection collection = new EmployeeCollection();
		collection.addEmployee(10,"Vrinda", "ABC");
		collection.addEmployee(3,"aVrinda", "ds");
		collection.addEmployee(4,"Sakshi", "SD");
		collection.addEmployee(4,"sachin", "SDC");
		collection.addEmployee(5,"sachin", "SDSC");
		collection.addEmployee(2,"mini", "qwe");
		
		List<Employee> peopleList = new LinkedList<Employee>();
		peopleList.addAll(EmployeeCollection.set);
		Collections.sort(peopleList,new  SortById());
		for (Employee emp : peopleList) {
            System.out.println(emp);
        }
	}

}
