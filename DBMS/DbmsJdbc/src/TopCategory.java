/**
 * @author Vrinda
 * Class for parent category attribute
 */
public class TopCategory {
	private String name;
	private int numberOfChildCategory;
	public TopCategory(String name, int numberOfChildCategory) {
	
		this.name = name;
		this.numberOfChildCategory = numberOfChildCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfChildCategory() {
		return numberOfChildCategory;
	}
	public void setNumberOfChildCategory(int numberOfChildCategory) {
		this.numberOfChildCategory = numberOfChildCategory;
	}
	
}
