package Question2;

public class Queue {

	private static int front, rear;
	private static int queue[];

	public Queue(int capacity) {
		front = rear = -1;
		queue = new int[capacity];
	}

	/**
	 * @param data to be inserted in queue
	 */
	public void enqueue(int data) {
		// check queue is full or not
		if (!isQueueFull()) {
			rear++;
			queue[rear] = data;
			if (front == -1){
				front = rear;
			}
		} 
		else{
			throw new AssertionError("Queue is Full");
		}
	}

	/**
	 * delete element from queue
	 */
	public void dequeue() {
		// if queue is empty
		if (!isQueueEmpty()) {
			front++;
			if (front > rear) {
				front = -1;
				rear = -1;
			}
		} else{
			throw new AssertionError("Queue is Empty");
		}
	}

	/**
	 * @return true if queue is full else false
	 */
	public boolean isQueueFull() {
		if ((rear + 1) == queue.length && front == 0){
			return true;
		}
		return false;
	}

	/**
	 * @return true if queue is empty else false
	 */
	public boolean isQueueEmpty() {
		if (rear == -1){
			return true;
		}
		return false;
	}

	public void print(){
		for(int i = front; i<rear+1; i++)
			System.out.println(queue[i]);
	}
}
