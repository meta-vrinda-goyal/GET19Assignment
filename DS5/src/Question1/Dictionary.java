package Question1;
import java.io.FileReader;
import java.util.List;
import java.util.Set;
import java.lang.Exception;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Dictionary implements DictionaryInterface{
	
	BinaryTree tree = new BinaryTree();
		public Dictionary(String fileName)  {
			try {
				JSONObject rootJSON = (JSONObject) new JSONParser().parse(new FileReader(fileName));
				@SuppressWarnings("unchecked")
				Set<String> keys = rootJSON.keySet();
				for (String i : keys) {
					DataEntry dataEntry = new DataEntry(Integer.parseInt(i), rootJSON.get(i).toString());
					tree.root = tree.insertData(tree.root, dataEntry);
				}
			} 
			catch (Exception ex) {
				throw new AssertionError("file not found");
			}
		}
	@Override
	public void addData(int key,String value) {
		DataEntry dataEntry = new DataEntry(key, value);
		tree.root = tree.insertData(tree.root, dataEntry);
	}
	@Override
	public void removeData(int key) {
		tree.root = tree.deleteEntry(tree.root, key);
	}
	@Override
	public String getValue(int key) {
		return tree.searchKey(tree.root, key);
	}
	@Override
	public List<DataEntry> getSortedList() {
		return tree. sortDictionary(tree.root);
	}

	@Override
	public  List<DataEntry> getSubSortedList(int k1, int k2){
		return tree.sortInRange(tree.root,k1, k2);
	}
}