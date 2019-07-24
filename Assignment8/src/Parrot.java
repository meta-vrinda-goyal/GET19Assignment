public class Parrot extends Bird {

	public Parrot(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);
	}

	@Override
	public String getSound() {
		return ("Talks/Screech");
	}

	public String eat() {
		return ("Raw Veggies");
	}
}
