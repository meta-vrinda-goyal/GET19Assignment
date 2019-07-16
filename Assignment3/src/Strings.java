
public class Strings{
	/**
	 * converts string to uppercase
	 * @param str string
	 * @return string
	 */
	String toUpperCase(String str){
		StringBuilder newHex = new StringBuilder();
		int i;
		char c;
		for (i = 0; i < str.length(); i++){
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				c = (char) (str.charAt(i) + 32);
			} 
			else{
				c = str.charAt(i);
			}
			newHex.append(c);
		}
		return newHex.toString();
	}

	/**
	 * @param str1 first string 
	 * @param str2 second string
	 * @return -1 if strings are not equal else 0
	 */
	int compareString(String str1, String str2){
		str1 = toUpperCase(str1);
		str2 = toUpperCase(str2);
		if (str1.length() != str2.length())
			return 0;
		else{
			for (int i = 0; i < str1.length(); i++){
				if (str1.charAt(i) != str2.charAt(i))
					return 0;
			}
		}
		return 1;
	}

	/**
	 * @param str string
	 * @return reverse of the input string
	 */
	String reverse(String str){
		StringBuilder newHex = new StringBuilder();
		for (int i = (str.length() - 1); i >= 0; i--){
			newHex.append(str.charAt(i));

		}

		return newHex.toString();
	}

	/**
	 * @param str string
	 * @return converts uppercase to lowercase and viceversa
	 */
	String getViceVersa(String str){
		StringBuilder newHex = new StringBuilder();
		for (int i = 0; i < str.length(); i++){
			
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				newHex.append((char) (str.charAt(i) + 32));
			}
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				newHex.append((char) (str.charAt(i) - 32));
			}
			else{
				newHex.append(str.charAt(i));
			}
			
		}
		return newHex.toString();
	}

	/**
	 * @param str string
	 * @return largest word in a given string
	 */
	String findLargestWord(String str){
		StringBuilder newHex = new StringBuilder();
		int max = 0;
		int index = 0;
		int i;
		int count;
		for (i = 0; i < str.length();){
			count = 0;
			while ((i < str.length()) && str.charAt(i) != ' '){
				count++;
				i++;
			}
			if (count >= max){
				max = count;
				index = i - max;

			}
			i++;
		}
		for (int j = 0; j < max; j++){

			newHex.append(str.charAt(index));
			index++;
		}
		return newHex.toString();
	}

	public static void main(String[] args){
		Strings strr = new Strings();
		System.out.println(strr.findLargestWord("Paas the String"));
		System.out.println(strr.reverse("Paas the String"));
		System.out.println(strr.compareString("Paas the String","abcd"));
		System.out.println(strr.getViceVersa("Paas the String"));
	}
}
