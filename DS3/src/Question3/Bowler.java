package Question3;

public class Bowler {

	private String name;
	private int noOfBalls ;
	public Bowler(String name, int noOfBalls) {
	
		this.name = name;
		this.noOfBalls = noOfBalls;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfBalls() {
		return noOfBalls;
	}
	public void setNoOfBalls(int noOfBalls) {
		this.noOfBalls = noOfBalls;
	}
	
}
