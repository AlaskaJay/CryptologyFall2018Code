// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class Attacker {
	public int[] frequencyCount(String message) {
		message = message.toUpperCase();
		int[] freq = new int[26];
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z')
				freq[message.charAt(i) - 'A']++;
		}
		return freq;
	}
	
	public String wordToPattern(String message) {
		String result = "";
		
		message = message.toUpperCase();
		char[] c = new char[26];
		boolean[] b = new boolean[26];
		int index = 0;
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				if(!b[message.charAt(i)-'A']) {
					b[message.charAt(i)-'A'] = true;
					c[index] = message.charAt(i);
					index++;
				} 
				for(int j = 0; j < index; j++) {
					if(c[j] == message.charAt(i)) {
						result += (char)(j+'A');
						break;
					}
				}
			}
		}
		
		return result;
	}
}
