public final class IntSet {
	// immutable array
	private final int[] array;
	// constructor
	public IntSet(int[] array) {
		this.array = array;
	}
	// access the array 
	public int[] getArray() {
		return array;
	}
	/**
	 * @param x number to be searched in set
	 * @return true if x is member of set else false
	 */
	public boolean isMember(int x) {
	    for (int i = 0; i < array.length; i++) {
		// search x in array
		    if (array[i] == x) {
			return true;
		    }
	    }
	    return false;
	}
	/**
	 * @return size of set
	 */
	public int size() {
	    return array.length; // size of array
	}
	/**
	 * @param s set
	 * @return true if s is a subset of the set else false
	 */
	public boolean isSubSet(IntSet s) {
	    // check size of subset
	    if (s.size() <= array.length) {
		int i, j;
		for (i = 0; i < s.size(); i++) {
		    for (j = 0; j < array.length; j++) {
			// check whether member of set s exist in array or not
			if (s.getArray()[i] == array[j]) {
			    break;
			}
		    }
		    // not found in array
		    if (j >= array.length){
			return false;
		    }
		}
		return true;
	    } 
	    else{
		return false;    //size of set is greater thus it cant be subset 
	    }
	}
	/**
	 * @return complement set where universal set is 1-1000
	 */
	public IntSet getCompliment() {
	    // set size of compliment array
	    int[] complimentArray = new int[1000 - array.length];
	    boolean isExist;
	    for (int i = 1, index = 0; i <= 1000; i++) {
		isExist = false;
		for (int j = 0; j < array.length; j++) {
		    // avoid member which exist in array
		    if (array[j] == i) {
			isExist = true;
		    }
		}
		if (!isExist) {
		    // check size of compliment array
		    if (index < complimentArray.length){
			complimentArray[index++] = i;
		    }
		    else{
			// A set is a well-defined collection of distinct objects
			throw new AssertionError("not a valid set");
		    }
		}
	    }
	    IntSet complimentSet = new IntSet(complimentArray);
	    return complimentSet;
	}
	/**
	 * @param s1 first set for union
	 * @param s2 second set for union
	 * @return set union of set s1 and set s2
	 */
	public static IntSet union(IntSet s1, IntSet s2) {
	    // get array of both set s1 and s2
	    int[] array1 = s1.getArray();
	    int[] array2 = s2.getArray();
	    // length of s1 and s2
	    int length1 = array1.length;
	    int length2 = array2.length;
	    int count = 0;
	    // count the common member in s1 and s2
	    for (int i = 0; i < length1; i++) {
	        for (int j = 0; j < length2; j++){
		    if (array1[i] == array2[j]){
			count++;
		    }
		}
	    }
	    // union array for s1 and s2
	    int[] unionArray = new int[length1 + length2 - count];
	    int index = 0;
	    for (int i = 0; i < length1; i++){
	        unionArray[i] = array1[i];   // add members of s1 in union array
	    }
	    for (int i = 0; i < length2; i++) {
	        int j;
		for (j = 0; j < length1; j++) {
		    if (array2[i] == unionArray[j]){ // check if member already exist in union array
		        break;
		    }
		}
		if (j == length1) {
		    // add member of s2 in union array
		    unionArray[length1 + index] = array2[i];
		    index++;
		}
	     }
	     // return union set of s1 and s2
	     return new IntSet(unionArray);
	}
}
