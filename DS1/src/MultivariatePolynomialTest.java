import static org.junit.Assert.*;
import org.junit.Test;

public class MultivariatePolynomialTest {

	@Test
	public void findDegreeOfValidPolynomialTest() {
		MultivariatePolynomial poly = new MultivariatePolynomial("22x22y2z+31x33yz33");
		assertEquals(67, poly.findDegree());		
	}
	
	@Test(expected = AssertionError.class)
	public void invalidPolynomialTest() {
		MultivariatePolynomial poly = new MultivariatePolynomial("22x%22y2z+31x33yz33");
	}
}
