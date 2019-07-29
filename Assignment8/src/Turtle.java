public class Turtle extends Reptiles {

	public Turtle(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	@Override
	public String getSound() {
		return ("Hooting");
	}

	public String eat() {
		return ("Fish pellets");
	}
}
