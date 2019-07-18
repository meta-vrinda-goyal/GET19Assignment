import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestSplitArray {
	@Test
	public void testForPositiveCase() {
		assertEquals( 3,ArrOperation.splitArray(new int[]{1, 1, 1, 2, 1}));
		assertEquals( -1,ArrOperation.splitArray(new int[] {2, 1, 1, 2, 1}));
		assertEquals( 1,ArrOperation.splitArray(new int[]{10,10}));
		
	}
	@Test 
	public void testForEmptyArray() {
		try {
			ArrOperation.splitArray(new int[]{});
		}
		catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}
}
