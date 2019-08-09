package Question1;

public class DataEntry {
	private int key;
	private String value;
	
	public DataEntry(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
}
