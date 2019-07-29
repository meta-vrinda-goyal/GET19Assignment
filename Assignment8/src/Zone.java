import java.util.ArrayList;
import java.util.List;

public class Zone {

	private String category;
	private int limitOfCages;
	
	public String getCategory() {
		return category;
	}
	
	public int getLimitOfCages() {
		return limitOfCages;
	}
	
	public List<Cage> cageList = new ArrayList<Cage>();

	public Zone(String category, int limitOfCages) {
		super();
		this.category = category;
		this.limitOfCages = limitOfCages;
	}
	
	public boolean hasPark() {
		return true;
	}
	
	public boolean hasCanteen() {
		return true;
	}
}
