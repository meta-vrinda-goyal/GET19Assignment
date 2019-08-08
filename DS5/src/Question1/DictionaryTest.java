package Question1;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Question1.DataEntry;
import Question1.Dictionary;
//test class to test operations on dictionary
public class DictionaryTest {

	//test case the list is sorted on the basis of key
	@Test
	public void sortingTest() {
		Dictionary d = new Dictionary("file.json");
		List<DataEntry> list = new ArrayList<DataEntry>();
		d.addData(33, "huma");
		d.addData(33, "huma");
		list = d.getSortedList();
		assertEquals("alia",d.getValue(1));
	}
	//test case to check value at a given key
	@Test
	public void getValueTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("vrinda",d.getValue(6));
	}
	//test case when key not found
	@Test
	public void keyNotFoundTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("key not found",d.getValue(277));
	}
	//test case to remove data from dictionary
	@Test
	public void removeDataTest() {
		Dictionary d = new Dictionary("file.json");
		List<DataEntry> list = new ArrayList<DataEntry>();
		d.removeData(4);
		list = d.getSortedList();
		assertEquals(4, list.size());
	}
}
