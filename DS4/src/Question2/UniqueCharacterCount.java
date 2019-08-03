package Question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCharacterCount {
	//map for cache
	private Map<String, Integer> map = new HashMap<String, Integer>();
	//set for unique characters
	private Set<Character> set = new HashSet<Character>();

	/**
	 * @param str string for unique characters count
	 * @return number of unique character in str string
	 */
	public int countUniqueCharacters(String str) {
		str = str.toLowerCase();
		// check if string previously encountered
		if (map.keySet().contains(str))
			// return previous value
			return map.get(str);
		// for a new string
		for (int i = 0; i < str.length(); i++) {
			// check if character is already exist in set
			if (!set.add(str.charAt(i)))
				// remove character from set
				set.remove(str.charAt(i));
		}
		// put string in map with number of unique characters
		map.put(str, set.size());
		// return number of unique characters
		return set.size();
	}

}
