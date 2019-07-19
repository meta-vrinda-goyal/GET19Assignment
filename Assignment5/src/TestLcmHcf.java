import static org.junit.Assert.*;

import org.junit.Test;


public class TestLcmHcf {

	@Test
	public void testLcm() {
		assertEquals(52, LcmHcf.getLcm(13,4));	
		assertEquals(4, LcmHcf.getLcm(2,4));	
		
	}
	@Test
	public void testHcf() {
		assertEquals(12, LcmHcf.getHcf(36,60));
		assertEquals(15, LcmHcf.getHcf(15,60));
	}
}
