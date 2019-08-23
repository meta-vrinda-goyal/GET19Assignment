package question1;

public interface UndirectedWeightedGraph {
	
	/**
	 * @return true if graph is connected graph
	 */
	public boolean isConnected();
	
	/**
	 * @param node of graph
	 * @return array of nodes which are reachable from node
	 */
	public int[] reachable(int node);
	
	/**
	 * @return minimum spanning tree
	 */
	public int[][] minimumSpanningTree();
	
	/**
	 * @param node1 of graph
	 * @param node2 of graph
	 * @return shortest path from node1 to node2
	 */
	public int shortestPath(int node1, int node2);
}