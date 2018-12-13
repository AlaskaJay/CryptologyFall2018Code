// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class Decipherer implements Cipherer{

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
		
		String s = "";
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= '1' && message.charAt(i) <= '5')
				s += message.charAt(i);
		}
		System.out.println(s);
		String result = "";
		
		for(int i = 0; i < s.length(); i+=2) {
			result += fullKey[Integer.parseInt(s.charAt(i)+"")-1][Integer.parseInt(s.charAt(i+1)+"")-1];
		}
		
		return result;
	}

	@Override
	public String shift(String message, String key) {
		String fullKey = createWordShiftKey(key);
		String result = "";
		
		for(int i = 0; i < message.length(); i++) {
			result += (char)(fullKey.indexOf(message.charAt(i)) + 'A');
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
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				char c = (char)((((message.charAt(i)-'A') - key)%26)+'A');
				if(c < 'A')
					c += 26;
				result += c;
			} else {
				result += message.charAt(i);
			}
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
