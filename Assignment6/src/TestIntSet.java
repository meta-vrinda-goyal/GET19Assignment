import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestIntSet {

	@Test
	public void TestMemberExistInSet() {
		assertFalse(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isMember(7));
		assertFalse(new IntSet(new int[] { 2, 3, 6, 8, 2, 5, 4, 5 }).isMember(7));
		assertTrue(new IntSet(new int[] { 1, 2, 3, 4, 5, 7 }).isMember(7));
		assertTrue(new IntSet(new int[] { 1, 2, 7, 4, 5, 6 }).isMember(7));
	}
	
	@Test
	public void TestSetSize(){
		assertEquals(6, new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).size());
		assertEquals(5, new IntSet(new int[] { 1, 2, 3, 4, 5 }).size());
		assertEquals(4, new IntSet(new int[] { 1, 2, 3, 4 }).size());
		assertEquals(1, new IntSet(new int[] { 1 }).size());
	}
	
	@Test
	public void TestSubsetInSet(){
		assertTrue(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isSubSet(new IntSet(new int[] { 1, 2, 3, 4, 5 })));
		assertTrue(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isSubSet(new IntSet(new int[] { 2, 6, 3 })));
		assertFalse(new IntSet(new int[] { 1, 2, 3, 4, 5, 6 }).isSubSet(new IntSet(new int[] { 1, 2, 3, 4, 5,7 })));
		assertFalse(new IntSet(new int[] { 1, 2, 3, 4, 5, 2, 3, 8 }).isSubSet(new IntSet(new int[] { 2, 3, 8, 7})));
	}
	
	@Test
	public void TestUnionOfSets(){
		
		assertArrayEquals(new IntSet(new int[] { 1, 2, 4,3 }).getArray(), IntSet.union(new IntSet(new int[] { 1, 2, 4}), new IntSet(new int[] { 2, 3 })).getArray());
	}

}
