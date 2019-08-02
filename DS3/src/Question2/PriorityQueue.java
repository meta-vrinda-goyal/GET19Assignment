package Question2;

public class PriorityQueue implements PriorityQueueInterface{
	
	private static int front, rear;
	private static Item queue[];
	int capacity;
	
    public PriorityQueue(int capacity) {
		this.capacity = capacity;
		front = rear = 0;
		queue = new Item[capacity];
	}

	/**
	 * @param data to be inserted in queue
	 */
	public void enqueueItem(Item data) {
		// check queue is full or not
		if (!isQueueFull()) {
			queue[rear] = data;			
			rear++;
		} 
		else{
			throw new AssertionError("Queue is Full");
		}
	}

	/**
	 * delete element from queue
	 */
	public void dequeueItem() {
		// if queue is not empty
		if (!isQueueEmpty()) {
			//set max priority as front
			int maxPriority = queue[front].getPriority();
			//set index as front
			int index = front;
			//get item of max priority
			for(int i = front+1; i< rear;i++){
				if(queue[i].getPriority() < maxPriority){
					index = i;
					maxPriority = queue[i].getPriority();
				}
			}
			//shift elements
			for(int i = index; i< rear-1; i++){
				queue[i] = queue[i+1];
				
			}
			//set last item as null
			queue[rear-1] = null;
			rear--;
		} 
		else{
			throw new AssertionError("Queue is Empty");
		}
	}

	/**
	 * @return true if queue is full else false
	 */
	public boolean isQueueFull() {
		if (capacity == rear){
			return true;
		}
		return false;
	}

	/**
	 * @return true if queue is empty else false
	 */
	public boolean isQueueEmpty() {
		if (rear == front){
			return true;
		}
		return false;
	}

	public void print(){
		for(int i = front; i<rear; i++)
			System.out.println(queue[i].getItem());
	}


}
