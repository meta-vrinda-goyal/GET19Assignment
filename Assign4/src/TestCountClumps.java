import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestCountClumps {
	@Test
	void testForPositiveCases() {
		assertEquals(1,ArrOperation.countClumps(new int[]{1, 2, 2, 3, 4}));
		assertEquals(2,ArrOperation.countClumps(new int[]{1, 1, 2, 1, 1}));
		assertEquals(1,ArrOperation.countClumps(new int[]{1, 1, 1, 1, 1}));
		
	}
	void testForEmptyArray() {
		try {
			ArrOperation.countClumps(new int[]{});
		}
		catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}
}
