//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//public class TestMaxMirror {
//
//	@Test
//	void testForPositiveCases() {
//		assertEquals( 3,ArrOperation.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
//		assertEquals( 2,ArrOperation.maxMirror(new int[]{7, 1, 4, 9, 7, 4, 1}));
//		assertEquals( 3,ArrOperation.maxMirror(new int[]{1, 2, 1, 4}));
//		assertEquals( 7,ArrOperation.maxMirror(new int[]{1, 4, 5, 3, 5, 4, 1}));
//	}
//	@Test
//	void testForEmptyArray() {
//		try {
//			ArrOperation.maxMirror(new int[]{});
//		} catch (AssertionError e) {
//			System.out.println("Array is empty");
//		}
//	}
//}
//
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMaxMirror {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {new int[]{1, 2, 3, 8, 9, 3, 2, 1 },3}, { new int[] {7, 1, 4, 9, 7, 4, 1}, 2}, { new int[] {1, 2, 1, 4}, 3},
                 { new int[] {1, 4, 5, 3, 5, 4, 1}, 7}
                 });
    }

    private int arrInput[];

    private int Expected;

    public TestMaxMirror(int input[], int expected) {
        this.arrInput = input;
        this.Expected = expected;
    }
    
    @Test
    public void testForPositiveCases() {
        assertEquals(Expected, ArrOperation.maxMirror(arrInput));
    }
    @Test
	public void testForEmptyArray() {
		try {
			ArrOperation.maxMirror(new int[]{});
		} catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}
    
}