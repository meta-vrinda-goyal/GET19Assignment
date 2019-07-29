public class Snake extends Reptiles {

	public Snake(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	public String eat() {
		return ("Small animals");
	}

	@Override
	public String getSound() {
		return ("Hiss");
	}
}
