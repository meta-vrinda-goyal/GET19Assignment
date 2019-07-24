import static org.junit.Assert.*;  

import org.junit.Ignore;
import org.junit.Test;


public class TestPoly {
	@Test
	public void testEvaluate() {
	    assertEquals(6, new Poly(new int[]{2,4}).evaluate(1), 0.0001);
	    assertEquals(10, new Poly(new int[]{2,4}).evaluate(2), 0.0001);
	    assertEquals(-2, new Poly(new int[]{2,4}).evaluate(-1), 0.0001);
	    assertEquals(7, new Poly(new int[]{1,4,2}).evaluate(1), 0.0001);
	}
	@Test
	public void testDegree(){
		assertEquals(1,new Poly(new int[]{2,4}).getDegree());
		assertEquals(3,new Poly(new int[]{2,4,7,8}).getDegree());
	}
	@Test
	public void testAddPoly(){
		Poly p = new Poly(new int[] {2,4,1});
		assertArrayEquals(new Poly(new int[]{4,8,1}).getArray(),p.addPoly(new Poly(new int[] {2,4})).getArray());
	}
	@Test                                                               
	public void testMultiplyPoly(){
		Poly p = new Poly(new int[] {1,2,3});
		Poly p2 = new Poly(new int[] {1,0,2});
		assertArrayEquals(new Poly(new int[]{4,10,16,6}).getArray(),p.multiplyPoly(new Poly(new int[] {4,2})).getArray());
		assertArrayEquals(new Poly(new int[]{1,2,5,4,6}).getArray(),p2.multiplyPoly(new Poly(new int[] {1,2,3})).getArray());
	}

}
