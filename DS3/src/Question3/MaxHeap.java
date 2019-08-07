package Question3;
public class MaxHeap { 
	private Bowler[] Heap; 
	private int sizeOfHeap; 
	public MaxHeap(int maxsize) 
	{ 
		this.sizeOfHeap = 0; 
		Heap = new Bowler[maxsize];
	} 
    /**
	 * @param pos 
	 * @return position of parent
	 */
	private int parent(int pos) { 
		return pos+1 / 2; 
	} 
    /**
	 * @param pos
	 * @return position of left child
	 */
	private int leftChild(int pos) { 
		return (2 * pos)+1; 
	} 
	/**
	 * @param pos
	 * @return position of right child
	 */
	private int rightChild(int pos) { 
		return (2 * pos) + 2; 
	} 
    /**
	 * @param pos
	 * @return true is element is at leaf position
	 */
	private boolean isLeaf(int pos) { 
		if (pos >= (sizeOfHeap / 2) && pos <= sizeOfHeap) { 
			return true; 
		} 
		return false; 
	} 

	/** swap the elements in heap
	 * @param firstPos
	 * @param SecondPos
	 */
	private void swap(int firstPos, int secondPos) {  
		Bowler tmp = Heap[firstPos]; 
        Heap[firstPos] = Heap[secondPos]; 
        Heap[secondPos] = tmp; 
		
	} 
    /**
	 * @param pos 
	 */
	private void maxHeapify(int pos) { 
		//if element is at leaf then it is heapified
		if (isLeaf(pos)) 
			return; 
		//compare elements of left child and right child
		if (Heap[pos].getNoOfBalls() < Heap[leftChild(pos)].getNoOfBalls() || Heap[pos].getNoOfBalls() < Heap[rightChild(pos)].getNoOfBalls()) { 
             if (Heap[leftChild(pos)].getNoOfBalls() > Heap[rightChild(pos)].getNoOfBalls()) { 
				swap(pos, leftChild(pos)); 
				maxHeapify(leftChild(pos)); 
			} 
			else { 
				swap(pos, rightChild(pos)); 
				maxHeapify(rightChild(pos)); 
			} 
		} 
	} 
    /**
	 * Inserts a new element to max heap 
	 * @param bowler
	 */
	public void insert(Bowler bowler) { 
		Heap[sizeOfHeap] = bowler;
		int current = sizeOfHeap; 
		while (Heap[current].getNoOfBalls() > Heap[parent(current)].getNoOfBalls()) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
		sizeOfHeap++;
	} 
    /**
     * @return max element from heap
     */
    public Bowler extractMax() { 
		
		Bowler bowler = Heap[0];
		Heap[0] = Heap[--sizeOfHeap]; 
		maxHeapify(0); 
		return bowler; 
	} 
} 
