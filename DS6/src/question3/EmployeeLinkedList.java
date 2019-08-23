package question3;
public class EmployeeLinkedList {
	// head node to point to first element
	public Node head = new Node(null);
	// last node to point to last element
	public Node last;
	public int size = 0;

	public EmployeeLinkedList() {
		this.last = null;
	}

	/**
	 * @param employee inserted in linkedList
	 */
	public void insertEmployee(Employee employee) {
		Node newNode = new Node(employee);
		// if list is empty
		if (last == null) {
			head.next = newNode;
			last = newNode;
		}
		// enter employee at last index
		else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	/**
	 * @param index of employee linked list
	 * @return employee on index
	 */
	private Employee get(int index) {
		//check index is valid or not
		if (index < size) {
			Node curr = head;
			for (int i = 0; i < index; i++)
				curr = curr.next;
			return curr.next.employee;
		} else
			throw new AssertionError("index out of bound");
	}

	/**
	 * sort employees by quick sort algorithm
	 */
	void quickSort() {
		sort(0, size - 1);
	}

	/**
	 * @param low index of employee list
	 * @param high index of employee list
	 */
	private void sort(int low, int high) {
		if (low < high) {
			int pi = partition(low, high);
			//recursive call
			sort(low, pi - 1);
			sort(pi + 1, high);
		}
	}

	/**
	 * @param low index of employee list
	 * @param high index of employee list
	 * @return
	 */
	private int partition(int low, int high) {
		//create a pivot employee
		Employee pivot = get(high);
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			//check any employee has salary greater than pivot
			if (get(j).getSalary() >= pivot.getSalary()) {
				//if salary is same than compare age
				if(get(j).getSalary() == pivot.getSalary() && get(j).getAge() > pivot.getAge())
					continue;
				i++;
				//swap data of employees
				String name = get(i).getName();
				int age = get(i).getAge();
				int salary = get(i).getSalary();
				get(i).setData(get(j).getName(), get(j).getAge(), get(j).getSalary());
				get(j).setData(name, age, salary);
			}
		}
		// set pivot employee on its correct position
		String name = get(i + 1).getName();
		int age = get(i + 1).getAge();
		int salary = get(i + 1).getSalary();
		get(i + 1).setData(get(high).getName(), get(high).getAge(), get(high).getSalary());
		get(high).setData(name, age, salary);
		return i + 1;
	}

	/**
	 * return employee list
	 */
	public String[] getEmplyeeList() {
		String[] employees = new String[size];
		Node curr = head.next;
		int i = 0;
		while (curr != null && i < size) {
			employees[i] = curr.employee.getName();
			curr = curr.next;
			i++;
		}
		return employees;
	}
}
