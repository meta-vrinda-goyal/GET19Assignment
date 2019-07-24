public class Eagle extends Bird {

	public Eagle(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	@Override
	public String getSound() {
		return ("Screams");
	}

	public String eat() {
		return ("Flesh");
	}
}
