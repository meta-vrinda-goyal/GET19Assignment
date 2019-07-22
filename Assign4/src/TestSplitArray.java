import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestSplitArray {
	@Test
	public void testForPositiveCase() {
		assertEquals( 3,ArrOperation.splitArray(new int[]{1, 1, 1, 2, 1}));
		assertEquals( -1,ArrOperation.splitArray(new int[] {2, 1, 1, 2, 1}));
		assertEquals( 1,ArrOperation.splitArray(new int[]{10,10}));
		
	}
	@Test(expected = AssertionError.class) 
	public void testForEmptyArray() {
		ArrOperation.splitArray(new int[]{});
	}
}
