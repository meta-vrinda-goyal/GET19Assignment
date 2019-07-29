public abstract class Bird extends Animal {

	public Bird(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	abstract public String getSound();
	
	public String physicalTraits() {
		return ("Birds have feathers on their body");
	}

	public String giveBirth() {
		return ("Birds lay eggs");
	}
}
