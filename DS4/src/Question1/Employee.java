package Question1;

public class Employee   {
	
	private int empId;
	private String name;
	private String address;
	
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public String toString() {
        return String.format("%d\t%s\t%s",empId, name, address);
    }
	
}
