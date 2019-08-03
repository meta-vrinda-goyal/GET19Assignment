package Question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrganicChemistryTest {

	@Test
	public void compoundMassOfValidCompoundTest() {
		OrganicChemistry obj1 =new OrganicChemistry();
		assertEquals(16, obj1.calculateCompoundMass("CH4"));
		assertEquals(180, obj1.calculateCompoundMass("C6H12O6"));
		assertEquals(791, obj1.calculateCompoundMass("C2H3(C12(OH)13)2(OH)2"));
	}
	
	@Test(expected = AssertionError.class)
	public void compoundMassOfInvalidCompoundTest(){
		OrganicChemistry obj =new OrganicChemistry();
		obj.calculateCompoundMass("C2H3regdgr(C12(OH)13)2(OH)2");
	}
}
