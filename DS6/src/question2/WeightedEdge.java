package question2;

public class WeightedEdge {
	private int vertex;
	private int weight;
	
	public WeightedEdge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}