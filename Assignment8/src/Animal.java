public abstract class Animal {
	private String name;
	private String type;
	private double weight;
	private int id;
	private int age;

	public Animal(String name, String type, double weight, int age, int id) {
        this.name = name;
		this.type = type;
		this.weight = weight;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	abstract public String getSound();
	
	public String eat() {
		return ("All animals eat");
	}
	
	public String physicalTraits() {
		return ("All animals have some unique physial traits");
	}
	
	public String giveBirth() {
		return ("All animals give birth");
	}
}
