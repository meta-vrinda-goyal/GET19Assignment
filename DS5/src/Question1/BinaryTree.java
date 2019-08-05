package Question1;
import java.util.ArrayList;
import java.util.List;
public class BinaryTree {
	
	public Node root;
	//list for storing sorted tree
	private List<DataEntry> listOfSorted = new ArrayList<DataEntry>();
	//list for storing sorted tree in given range
	private List<DataEntry> listOfSortedInRange = new ArrayList<DataEntry>();
	
	public BinaryTree() {
		root = null;
	}
	/**
	 * @param dataEntry 
	 */
	public void insert(DataEntry dataEntry) { 
		 root = insertData(root,dataEntry); 
	} 
	/**
	 * @param root node of tree
	 * @param dataEntry: dictionary entry
	 * @return insert data in dictionary binary tree
	 */
	public Node insertData(Node root , DataEntry dataEntry){
		//if tree is empty
		if(root == null){
			root = new Node(dataEntry);
			return root;
		}
		//if key is less than root's key
		if(root.getEntry().getKey() > dataEntry.getKey()){
			root.setlChild(insertData(root.getlChild(),dataEntry));
		}
		//if key is greater than root's key
		else if(root.getEntry().getKey() < dataEntry.getKey()){
			root.setrChild(insertData(root.getrChild(),dataEntry))  ;
		}
		//if key is not unique
		else {
			return root;
		}
		return root;
	}
	
	public String searchKey(Node root, int key){
		//if key not found
		if(root == null){
			return "key not found";
		}
		//if key is found
	    else if(root.getEntry().getKey() == key){
			return root.getEntry().getValue();
		}
		//if key is less than search in left subtree
		else if(root.getEntry().getKey() > key){
			return searchKey(root.getlChild(), key);
		}
		//if key is greater than search in right subtree
		else{
			return searchKey(root.getrChild(), key);
		}
	}
	public List<DataEntry> sortDictionary(){
		sort(root);
		return listOfSorted;
	}
	/**
	 * method to sort tree
	 * @param root
	 */
	public void sort(Node root){
		if (root != null) { 
			//sort left subtree
            sort(root.getlChild());
            //add root to list
            listOfSorted.add(root.getEntry());
            //sort right subtree
            sort(root.getrChild()); 
        } 
	}
	public List<DataEntry> sortSubDictionary(int k1,int k2){
		sort2(root,k1,k2);
		return listOfSortedInRange;
	}
	/**
	 * method sorts the element in given range
	 * @param root
	 * @param k1
	 * @param k2
	 */
	public void sort2(Node root, int k1,int k2){
	     if (root != null) { 
             sort2(root.getlChild(),k1,k2);
             if(root.getEntry().getKey()>=k1 && root.getEntry().getKey()<=k2){
                  listOfSortedInRange.add(root.getEntry());
             }
             sort2(root.getrChild(),k1,k2); 
         } 
	}
	
	public void deleteKey(int key) { 
        root = deleteRec(root, key); 
    } 
   
    /**
     * @param root
     * @param key
     * @return tree after deleting the node
     */
    public Node deleteRec(Node root, int key) { 
    	//Base Case: If the tree is empty 
    	if (root == null){
    		return root; 
    	}
        if (key < root.getEntry().getKey()) {
            root.setlChild(deleteRec(root.getlChild(), key)); 
        }
        else if (key > root.getEntry().getKey()) {
        	root.setrChild(deleteRec(root.getrChild(), key)); 
        }
        // if key is found 
        else
        {   // node with only one child or no child 
            if (root.getlChild() == null) {
                return root.getrChild(); 
            }
            else if (root.getrChild() == null) {
                return root.getlChild(); 
            }
            // node with two children: Get the inorder successor (smallest  in the right subtree) 
            root.getEntry().setKey(minValue(root.getrChild())); 
  
            // Delete the inorder successor 
            root.setrChild(deleteRec(root.getrChild(), root.getEntry().getKey()));
        } 
        return root; 
    } 
    /**
     * @param root
     * @return minimum value in tree
     */
    public int minValue(Node root) { 
        int minv = root.getEntry().getKey(); 
        while (root.getlChild() != null) { 
            minv = root.getlChild().getEntry().getKey(); 
            root = root.getlChild(); 
        } 
        return minv; 
    } 
}
