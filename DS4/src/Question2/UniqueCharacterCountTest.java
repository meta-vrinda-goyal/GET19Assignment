package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterCountTest {

	@Test
	public void countUniqueCharactersTest() {
		UniqueCharacterCount obj = new UniqueCharacterCount();
		assertEquals(2, obj.countUniqueCharacters("sakshiKain"));
		assertEquals(7, obj.countUniqueCharacters("sachinGidwani"));
		assertEquals(8, obj.countUniqueCharacters("VrindaGoyal"));
	}

}
