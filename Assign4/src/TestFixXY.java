import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
public class TestFixXY {
	@Test
	public void testPositiveCases() {
		assertArrayEquals( new int[]{9, 4, 5, 4, 5, 9},ArrOperation.fixXY(new int[]{5, 4, 9, 4, 9, 5},4,5));
		assertArrayEquals( new int[]{1, 4, 5, 1},ArrOperation.fixXY(new int[]{1, 4, 1, 5},4,5));
		assertArrayEquals( new int[]{1, 4, 5, 1, 1, 4, 5},ArrOperation.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1},4,5));
	}

	@Test(expected = AssertionError.class)
	public void testForEmptyArray(){
		ArrOperation.fixXY(new int[]{},4,5);
	}
	@Test(expected = AssertionError.class)
	public void TestForUnequalXY(){
		ArrOperation.fixXY(new int[]{5, 4, 9,4, 9},4,5);
	}
	@Test(expected = AssertionError.class)
	public void testForAdjacentX(){
		ArrOperation.fixXY(new int[]{5, 4, 4, 9, 5},4,5);
	}
	@Test(expected = AssertionError.class)
	public void testForXAtLastIndex(){
		ArrOperation.fixXY(new int[]{5, 4, 5, 9, 4},4,5);
	}

}
