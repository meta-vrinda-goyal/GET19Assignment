public abstract class Reptiles extends Animal {

	public Reptiles(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	abstract public String getSound();
	
	public String physicalTraits() {
		return ("Reptiles have scale on their body");
	}

	public String giveBirth() {
		return ("Reptiles lay eggs");
	}
}
