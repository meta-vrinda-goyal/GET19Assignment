package Question2;
import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

	@Test
	public void queueTest() {
		Queue queue = new Queue(5);
		assertTrue(queue.isQueueEmpty());
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		assertTrue(queue.isQueueFull());
		queue.dequeue();
		queue.enqueue(6);
		//queue.dequeue();
		
		queue.print();
		assertTrue(queue.isQueueFull());
		assertFalse(queue.isQueueEmpty());
	}

}
