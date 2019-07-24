public class Lion extends Mammal {

	public Lion(String name, String type, double weight, int id, int age) {
		super(name, type, weight, id, age);	
	}

	public String eat(){
		return ("Flesh");
	}

	@Override
	public String getSound() {
		return "roar";
	}
}
