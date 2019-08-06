package Question1;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Question1.DataEntry;
import Question1.Dictionary;

public class DictionaryTest {

	@Test
	public void sortingFullDictionaryTest() {
		Dictionary d = new Dictionary("file.json");
		List<DataEntry> list = new ArrayList<DataEntry>();
		d.addData(33, "hu");
		d.addData(33, "hu");
		
		list = d.getSortedList();
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
		}
		System.out.println();
	}
	@Test
	public void sortingDictionaryInRangeTest() {
		Dictionary d = new Dictionary("file.json");
		List<DataEntry> list = new ArrayList<DataEntry>();
		d.addData(33, "hu");
		d.addData(33, "hu");
		
		list = d.getSubSortedList(2,6);
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
		}
		System.out.println();
	}
	
	@Test
	public void getValueTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("vrinda",d.getValue(6));
	}
	@Test
	public void keyNotFoundTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("key not found",d.getValue(277));
	}
	@Test
	public void removeDataTest() {
		Dictionary d = new Dictionary("file.json");
		List<DataEntry> list = new ArrayList<DataEntry>();
		d.removeData(4);
		list = d.getSortedList();
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
		}
		System.out.println();
	}
}
