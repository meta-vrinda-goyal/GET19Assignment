package Question2;
import static org.junit.Assert.*;
import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void queueTest() {
		PriorityQueue queue = new PriorityQueue(5);
		assertTrue(queue.isQueueEmpty());
		queue.enqueueItem(new Item(2,22));
		queue.enqueueItem(new Item(3,7));
		queue.enqueueItem(new Item(4,2));
		queue.enqueueItem(new Item(0,5));
		queue.enqueueItem(new Item(8,9));
		assertTrue(queue.isQueueFull());
		queue.dequeueItem();
	    queue.dequeueItem();
		queue.print();
		queue.enqueueItem(new Item(44,2));
		assertFalse(queue.isQueueFull());
		assertFalse(queue.isQueueEmpty());
	}

}
