interface Calculator {
	public String add(String hex1, String hex2);

	public String sub(String hex1, String hex2);

	public String mul(String hex1, String hex2);

	public String div(String hex1, String hex2);

	public boolean compareIfEq(String hex1, String hex2);

	public boolean compareIfGreater(String hex1, String hex2);

	public boolean compareIfLess(String hex1, String hex2);

	public void comp(String hex1, String hex2);

	public String removePrecZero(String hex);
}

public class HexCalc implements Calculator {
	boolean greater = false, equal = false, smaller = false;

	public int hexToDec(String hex) {
		hex = hex.toUpperCase();
		int base = 16;
		int dec = 0;
		for (int i = 0; i < hex.length(); i++) {
			if (hex.charAt(i) >= '0' && hex.charAt(i) <= '9')
				dec = base * dec + (hex.charAt(i) - 48); // if character is digit b/w 0 and 9 subtract ascii value of 0
															// i.e 48 to convert to int
			else if (hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F')
				dec = base * dec + (hex.charAt(i) - 55);

		}
		return dec;
	}

	public String decToHex(int dec) {
		int rem;
		int base = 16;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		if (dec == 0)
			return ("0");
		while (dec > 0) {
			rem = dec % base;
			hex = hexchars[rem] + hex;
			dec = dec / base;
		}
		System.out.println(hex);
		return hex;
	}

	public String add(String hex1, String hex2) {
		int dec1 = hexToDec(hex1);
		int dec2 = hexToDec(hex2);
		int ans = dec1 + dec2;
		String ans2 = decToHex(ans);
		return ans2;
	}

	public String sub(String hex1, String hex2) {
		int dec1 = hexToDec(hex1);
		int dec2 = hexToDec(hex2);
		int ans = dec1 - dec2;
		if (ans >= 0) {
			String ans2 = decToHex(ans);
			return ans2;
		} else {
			int ans3 = -1 * ans;
			String ans2 = decToHex(ans3);
			return ("-" + ans2);
		}
	}

	public String mul(String hex1, String hex2) {
		int dec1 = hexToDec(hex1);
		int dec2 = hexToDec(hex2);
		int ans = dec1 * dec2;
		String ans2 = decToHex(ans);
		return ans2;
	}

	public String div(String hex1, String hex2) {
		int dec1 = hexToDec(hex1);
		int dec2 = hexToDec(hex2);
		if (dec2 == 0) {
			return ("Division by zero error");
		}

		else {
			int ans = dec1 / dec2;
			String ans2 = decToHex(ans);
			return ans2;
		}
	}

	/*
	 * Function to remove preceding zero from a string i.e 0A is same as A;
	 */
	public String removePrecZero(String hex) {

		StringBuilder newHex = new StringBuilder(); // using Stringbuilder since string is immutable
		int i;
		/* getting the index at which non-zero characters begin */
		for (i = 0; i < hex.length(); i++) {
			if (hex.charAt(i) == '0')
				continue;
			else
				break;
		}
		/* appending the characters to a new string */
		for (int j = i; j < hex.length(); j++) {
			newHex.append(hex.charAt(j));
		}
		return (newHex.toString());
	}

	public boolean compareIfEq(String hex1, String hex2) {
		comp(hex1, hex2);
		if (equal == true)
			return true;
		else
			return false;

	}

	public boolean compareIfLess(String hex1, String hex2) {

		comp(hex1, hex2);
		if (smaller == true)
			return true;
		else
			return false;
	}

	public boolean compareIfGreater(String hex1, String hex2) {
		comp(hex1, hex2);
		if (greater == true)
			return true;
		else
			return false;
	}

	public void comp(String hex1, String hex2) {
		hex1 = hex1.toUpperCase();
		hex2 = hex2.toUpperCase();
		hex1 = removePrecZero(hex1);
		hex2 = removePrecZero(hex2);
		if (hex1.length() > hex2.length())
			greater = true;
		else if (hex1.length() < hex2.length())
			smaller = true;
		int i = 0;
		if (hex1.length() == hex2.length()) {
			for (i = 0; i < hex1.length(); i++) {
				if (hex1.charAt(i) > hex2.charAt(i)) {
					greater = true;
					break;
				}
				if (hex1.charAt(i) < hex2.charAt(i)) {
					smaller = true;
					break;
				}
			}
		}
		if (i == hex1.length()) {
			equal = true;
		}
	}

	/* check whether the input string is a valid hexadecimal or not */
	public boolean isHex(String hex) {
		hex = hex.toUpperCase();
		int i;
		for (i = 0; i < hex.length(); i++) {
			if ((hex.charAt(i) >= '0' && hex.charAt(i) <= '9') || (hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F')) {
				continue;
			} else
				break;
		}
		return (i == hex.length()) ? true : false;
	}
}
