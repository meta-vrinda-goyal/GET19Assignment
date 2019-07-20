import static org.junit.Assert.*;
import org.junit.Test;

public class TestSearchAlgo {

	@Test
	public void testLinearSearchIfElementExist() {
		assertEquals(4, Search.doLinearSearch(new int[] {1,2,5,6,4,7},4));
		assertEquals(2, Search.doLinearSearch(new int[] {0,6,5,8,23,4},5));
	}
	@Test(expected = AssertionError.class) 
	public void TestLinearIfElementNotExist() {
		Search.doLinearSearch(new int[]{1,2,3,4,5},6);
	}
	@Test
	public void testBinarySearch() {
		assertEquals(3, Search.doBinarySearch(new int[] {1,2,3,4,5,5},4));
		assertEquals(1, Search.doBinarySearch(new int[] {1,2,3,4,5,5,9,62,89},2));
		assertEquals(8, Search.doBinarySearch(new int[] {1,2,3,4,5,5,9,62,89},89));
	}
	
	@Test(expected = AssertionError.class) 
	public void TestBinaryIfElementNotExist() {
		Search.doBinarySearch(new int[]{1,2,3,4,5},66);
		
	}

}
