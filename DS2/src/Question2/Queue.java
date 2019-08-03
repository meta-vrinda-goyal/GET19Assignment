package Question2;
public class Queue {

	private static int front, rear;
	private static int queue[];
	private int capacity;
	private static int currentSize;

	public Queue(int capacity) {
		front = rear = -1;
		currentSize = 0;
		this.capacity = capacity;
		queue = new int[capacity];
	}

	/**
	 * @param data for insert in queue
	 */
	public void enqueue(int data) {
		// check queue is full or not
		if (!isQueueFull()) {
			rear = (rear + 1) % capacity;
			queue[rear] = data;
			currentSize++;
			if (front == -1)
				front = rear;
		} else
			throw new AssertionError("Queue is Full");
	}

	/**
	 * delete element from queue
	 */
	public void dequeue() {
		// if queue is empty
		if (!isQueueEmpty()) {
			front = (front + 1) % capacity;
			currentSize--;
		} else
			throw new AssertionError("Queue is Empty");
	}

	/**
	 * @return true if queue is full else false
	 */
	public boolean isQueueFull() {
		if (currentSize == capacity)
			return true;
		return false;
	}

	/**
	 * @return true if queue is empty else false
	 */
	public boolean isQueueEmpty() {
		if (currentSize == 0)
			return true;
		return false;
	}

	public void print(){
		for(int i=front;i<rear+1;i++)
			System.out.println(queue[i]);
	}
}
