package Question1;

import java.util.Comparator;

public class SortById implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		//compare Id of employee e1 and e2 
		return e1.getEmpId() - e2.getEmpId();
	}
}
