import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class TestPoly {

	@Test
	public void polyTest() {
		MultivariatePoly poly = new MultivariatePoly();
		List<Integer> terms = new ArrayList<Integer>();
		terms.add(2);
		terms.add(1);
		terms.add(1);
		terms.add(1);
		terms.add(0);
		terms.add(6);
		terms.add(1);
		terms.add(1);
		terms.add(1);
		terms.add(0);
		terms.add(0);
		terms.add(7);
		poly.formPoly(3, terms);
		assertEquals(7, poly.findDegree());
	}

}
