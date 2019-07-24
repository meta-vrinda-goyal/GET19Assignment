import java.util.ArrayList;
import java.util.List;

public class Cage {
	private int capacity;
	String typeOfAnimal;
	public List<Animal> animal = new ArrayList<Animal>();

	public Cage(String typeOfAnimal, int capacity) {
		this.capacity = capacity;
		this.typeOfAnimal = typeOfAnimal;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public void setTypeOfAnimal(String typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}

}
