// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.cipherers;

public class StringManipulator {
	public static String removeSpacing(String s) {
		String result = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ' ')
				result += s.charAt(i);
		}
		
		return result;
	}
	
	public static String removePuncuation(String s) {
		String result = "";
		
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				result += s.charAt(i);
		}
		
		return result;
	}

	public static String onlyLetters(String s) {
		String result = "";
		
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
				result += s.charAt(i);
		}
		
		return result;
	}
	
	public static String onlyNumbers(String s) {
		String result = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') 
				result += s.charAt(i);
		}
		
		return result;
	}
	
	public static String reverseString(String s) {
		String result = "";
		for(int i = 1; i <= s.length(); i++) {
			result += s.charAt(s.length()-i);
		}
		return result;
	}
	
	public static boolean intParseable(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static String createWordShiftKey(String key) {
		boolean[] usedChars = new boolean[26];
		usedChars['J'-'A'] = true;
		key = key.toUpperCase();
		String result = "";
		
		for(int i = 0; i < key.length(); i++) {
			if(key.charAt(i) >= 'A' && key.charAt(i) <= 'Z') {
				if(!usedChars[key.charAt(i)-'A']) {
					result+=key.charAt(i);
					usedChars[key.charAt(i)-'A'] = true;
				}
			}
		}
		
		for(int i = 0; i < usedChars.length; i++) {
			if(!usedChars[i])
				result += (char)(i+'A');
		}
		
		return result;
	}

	public static char[][] polybiusKey(String key) {
		String fullKey = createWordShiftKey(key);
		char[][] result = new char[5][5];
		int count = 0;
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				while(fullKey.toLowerCase().charAt(count) == 'j') {
					count++;
				}
				result[i][j] = fullKey.charAt(count);
				count++;
			}
		}
		return result;
	}
}
