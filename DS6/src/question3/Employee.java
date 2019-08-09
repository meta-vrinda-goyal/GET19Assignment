package question3;

public class Employee {

	private String name;
	private int age;
	private int salary;

	public Employee(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getSalary() {
		return salary;
	}

	public void setData(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String toString(){
		return String.format("%s\t%d\t%d", name, age, salary);
	}
}
