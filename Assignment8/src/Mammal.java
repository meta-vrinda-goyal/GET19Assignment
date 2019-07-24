public abstract class Mammal extends Animal {

	public Mammal(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	abstract public String getSound();
	
	public String physicalTraits() {
		return ("Mammals have hair on their body");
	}

	public String giveBirth() {
		return ("Mammals give birth to younger individuals");
	}

}
