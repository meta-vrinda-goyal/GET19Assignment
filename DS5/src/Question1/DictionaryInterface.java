package Question1;
import java.util.List;


public interface DictionaryInterface {
	
	public void addData(int key, String value);
	public void removeData(int key);
	public String getValue(int key);
	public List<DataEntry> getSortedList();
	public List<DataEntry> getSubSortedList(int k1, int k2);
	
}
