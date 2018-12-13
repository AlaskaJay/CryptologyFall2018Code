// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.ciphers;

import main.cipherers.StringManipulator;

public class CaesarShift extends Cipher{
	protected int trueKey;

	public CaesarShift(String message, String key) {
		super(message, key);
		findTrueKey();
	}
	
	private void findTrueKey() {
		if(StringManipulator.intParseable(key)) {
			trueKey = Integer.parseInt(key);
		} else {
			trueKey = (int)(key.toUpperCase().charAt(0) - 'A');
		}
	}

	@Override
	public String encipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		String result = "";
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				result += add(message.charAt(i), 'A');	
				//System.out.print(add(message.charAt(i), 'A'));
			} else if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
				result += add(message.charAt(i), 'a');				
				//System.out.print(add(message.charAt(i), 'a'));
			} else if(message.charAt(i) == ' ' && preserveSpacing) {
				result += ' ';
			} else if (preservePunct) {
				result += message.charAt(i);
			}
		}
		
		if(!preserveCase) {
			result = result.toUpperCase();
		}
		
		return result;
	}
	
	private char add(char m, char c) {
		return (char)(c + (((m+trueKey)-c)%26));
	}

	@Override
	public String decipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		String result = "";
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				result += sub(message.charAt(i), 'A');
			} else if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
				result += sub(message.charAt(i), 'a');				
			} else if(message.charAt(i) == ' ' && preserveSpacing) {
				result += ' ';
			} else if (preservePunct) {
				result += message.charAt(i);
			}
		}
		
		if(!preserveCase) {
			result = result.toUpperCase();
		}
		
		return result;
	}
	
	private char sub(char m, char c) {
		int i = m - (c + trueKey);
		if(i < 0)
			i += 26;
		return (char)(i + c);
	}
}
