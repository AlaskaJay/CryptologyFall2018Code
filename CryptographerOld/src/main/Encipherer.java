// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class Encipherer implements Cipherer{

	@Override
	public String createWordShiftKey(String key) {
		boolean[] usedChars = new boolean[26];
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

	@Override
	public char[][] polybiusKey(String key) {
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

	@Override
	public String polybius(String message, String key) {
		char[][] fullKey = polybiusKey(key);
		String result = "";
		message = message.toUpperCase();
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				result += polybiusHelper(fullKey, message.charAt(i));
			}
		}
		
		return result;
	}
	
	private String polybiusHelper(char[][] key, char c) {
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < key[i].length; j++) {
				if(key[i][j] == c) {
					return i+""+j;
				}
			}
		}
		return null;
	}

	@Override
	public String shift(String message, String key) {
		String fullKey = createWordShiftKey(key);
		String result = "";
		message = message.toUpperCase();
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				result += fullKey.charAt(message.charAt(i)-'A');
			}
		}
		
		return result;
	}
	
	@Override
	public String rot13(String message) {
		return ceaser(message, 13);
	}

	@Override
	public String ceaser(String message) {
		String result = "";
		for(int i = 0; i < 26; i++) {
			result += ceaser(message, i) + "\n";
		}
		return result;
	}

	@Override
	public String ceaser(String message, String key) {
		return ceaser(message, key.charAt(0));
	}

	@Override
	public String ceaser(String message, char key) {
		int trueKey = 0;
		if(key >= 'A' && key <= 'Z')
			trueKey = key - 'A';
		if(key >= 'a' && key <= 'z')
			trueKey = key - 'a';
		return ceaser(message, trueKey);
	}

	@Override
	public String ceaser(String message, int key) {
		String result = "";
		message = message.toUpperCase();
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z')
				result += (char)((((message.charAt(i)-'A') + key)%26)+'A');
		}
		return result;
	}

	@Override
	public String atbash(String message) {
		message = message.toUpperCase();
		String result = "";
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				result += (char)(('Z' - message.charAt(i)) + 'A');
			}
		}
		
		return result;
	}
}
