// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.ciphers;

import main.cipherers.StringManipulator;

public class Veginere extends Cipher{
	private String trueKey;
	
	public Veginere(String message, String key) {
		super(message, key);
		findTrueKey();
	}
	
	private void findTrueKey() {
		trueKey = key.toUpperCase();
		trueKey = StringManipulator.onlyLetters(trueKey);
	}

	@Override
	public String encipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		String result = "";
		
		int k = 0;
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				result += add(message.charAt(i), 'A', trueKey.charAt(k));
				k++;
				if(k >= trueKey.length())
					k = 0;
			} else if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
				result += add(message.charAt(i), 'a', trueKey.charAt(k));
				k++;
				if(k >= trueKey.length())
					k = 0;
			} else if(message.charAt(i) == ' ' && preserveSpacing) {
				result += ' ';
			} else if (preservePunct) {
				result += message.charAt(i);
			}
		}
		
		return result;
	}
	
	private char add(char m, char o, char k) {
		// m-o is the number of the letter of the alphabet in the message
		// k-'A' is the number of the letter of the alphabet in the key
		//System.out.println(m + ", " + o + ", " + k + ", " + ((m-o)+(k-'A'))%26);
		return (char)(((m-o)+(k-'A'))%26 + o);
	}

	@Override
	public String decipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		String result = "";
		
		System.out.println(message);
		System.out.println(trueKey);
		
		int k = 0;
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				result += sub(message.charAt(i), 'A', trueKey.charAt(k));
				k++;
				if(k >= trueKey.length())
					k = 0;
			} else if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
				result += sub(message.charAt(i), 'a', trueKey.charAt(k));
				k++;
				if(k >= trueKey.length())
					k = 0;
			} else if(message.charAt(i) == ' ' && preserveSpacing) {
				result += ' ';
			} else if (preservePunct) {
				result += message.charAt(i);
			}
		}
		
		return result;
	}
	
	private char sub(char m, char o, char k) {
		int num = (m-o)-(k-'A');
		if(num < 0)
			num += 26;
		return (char)(num+o);
	}
}
