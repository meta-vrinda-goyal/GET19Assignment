import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestCountClumps {
	@Test
	public void testForPositiveCases() {
		assertEquals(1,ArrOperation.countClumps(new int[]{1, 2, 2, 3, 4}));
		assertEquals(2,ArrOperation.countClumps(new int[]{1, 1, 2, 1, 1}));
		assertEquals(1,ArrOperation.countClumps(new int[]{1, 1, 1, 1, 1}));
		
	}
	@Test(expected = AssertionError.class)
	public void testForEmptyArray() {
		ArrOperation.countClumps(new int[]{});
	}
}
