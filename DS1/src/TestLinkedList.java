import static org.junit.Assert.*;

import org.junit.Test;
public class TestLinkedList {

	@Test
	public void rotateSubstringTest() {
	    LinkedList list = new LinkedList(); 
		RotateSubList list2 = new RotateSubList();
        list = list.insert(list, 1); 
        list = list.insert(list, 2); 
        list = list.insert(list, 3); 
        list = list.insert(list, 4); 
        list = list.insert(list, 5); 
        list = list.insert(list, 6); 
        list = list.insert(list, 7); 
        list = list.insert(list, 8);
        list2.rotateSubList(list, 2,5,3);
        // Print the LinkedList 
        list.printList(list); 
	}
	@Test(expected = AssertionError.class)
	public void ifLIsGreaterThanR(){
		LinkedList list = new LinkedList(); 
		RotateSubList list2 = new RotateSubList();
        list = list.insert(list, 1); 
        list = list.insert(list, 2); 
        list = list.insert(list, 3); 
        list = list.insert(list, 4); 
        list = list.insert(list, 5); 
        list = list.insert(list, 6); 
        list = list.insert(list, 7); 
        list = list.insert(list, 8);
        list2.rotateSubList(list, 5,2,3);
	}
	@Test
	public void checkLoopTest() {
		LinkedList list = new LinkedList(); 
		CheckLoop checkLoop = new CheckLoop();
		list = list.insert(list, 1); 
        list = list.insert(list, 2); 
        list = list.insert(list, 3); 
        list = list.insert(list, 4); 
        assertFalse(checkLoop.detectLoop(list));
        list.head.next.next= list.head.next;
        assertTrue(checkLoop.detectLoop(list));
        
	}

}
