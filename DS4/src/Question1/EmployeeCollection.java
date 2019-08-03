package Question1;

import java.util.HashSet;

public class EmployeeCollection {
	
	//collection of employee made using a set
         HashSet<Employee> set=new HashSet<Employee>();
	/**
	 * method adds employee to set
	 * @param empId of employee
	 * @param name of employee
	 * @param address of employee
	 */
	public void addEmployee(int empId, String name, String address){
		
		Employee employee = new Employee(empId, name, address);
		//to check whether id is unique or not
		boolean isIdUnique = true;
		for(Employee emp:set){ 
			if( emp.getEmpId() == empId ){
				//if id already exist 
				isIdUnique = false;
				break;
			}
		}
		//if id is unique add employee to set
		if(isIdUnique){
			set.add(employee);
		}
	}
}
