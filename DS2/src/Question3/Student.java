package Question3;

public class Student {

	private String name;
	private String[] preference = new String[5];

	public void setName(String name) {
		this.name = name;
	}

	public void setPreference(String[] preference) {
		this.preference = preference;
	}

	public String getName() {
		return name;
	}

	public String[] getPreference() {
		return preference;
	}	
}
