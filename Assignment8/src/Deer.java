public class Deer extends Mammal {

	public Deer(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	public String eat() {
		return ("Plants");
	}
	@Override
	public String getSound() {
		return "snorts";
	}
}
