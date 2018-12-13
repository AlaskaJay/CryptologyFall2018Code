// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class MatrixEncrypt {
	public static String cleanString(String message) {
		String hold = "";
		message = message.toUpperCase();
		
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z')
				hold+=message.charAt(i);
		}
		return hold;
	}
	
	public static String encrypt2x2(String message, int[][] key) {
		String result = "";
		String hold = cleanString(message);
		while(hold.length()%2 != 0) {
			hold+='X';
		}
		
		for(int i = 0; i < hold.length(); i+=2) {
			int a0 = hold.charAt(i) - 'A';
			int a1 = hold.charAt(i+1) - 'A';

			char c0 = (char) ((key[0][0]*a0 + key[0][1]*a1)%26 + 'A');
			char c1 = (char) ((key[1][0]*a0 + key[1][1]*a1)%26 + 'A');
			
			result += c0 + "" + c1;
		}
		
		return result;
	}
	
	public static String encrypt3x3(String message, int[][] key) {
		String result = "";
		String hold = cleanString(message);
		while(hold.length()%3 != 0) {
			hold+='X';
		}
		
		for(int i = 0; i < hold.length(); i+=3) {
			int a0 = hold.charAt(i) - 'A';
			int a1 = hold.charAt(i+1) - 'A';
			int a2 = hold.charAt(i+2) - 'A';
			
			char c0 = (char) ((key[0][0]*a0 + key[0][1]*a1 + key[0][2]*a2)%26 + 'A');
			char c1 = (char) ((key[1][0]*a0 + key[1][1]*a1 + key[1][2]*a2)%26 + 'A');
			char c2 = (char) ((key[2][0]*a0 + key[2][1]*a1 + key[2][2]*a2)%26 + 'A');
			
			result += c0 + "" + c1 + "" + c2;
		}
		
		return result;
	}
	
	public static String encrypt4x4(String message, int[][] key) {
		String result = "";
		String hold = cleanString(message);
		while(hold.length()%4 != 0) {
			hold+='X';
		}
		
		for(int i = 0; i < hold.length(); i+=4) {
			int a0 = hold.charAt(i) - 'A';
			int a1 = hold.charAt(i+1) - 'A';
			int a2 = hold.charAt(i+2) - 'A';
			int a3 = hold.charAt(i+3) - 'A';
			
			char c0 = (char) ((key[0][0]*a0 + key[0][1]*a1 + key[0][2]*a2 + key[0][3]*a3)%26 + 'A');
			char c1 = (char) ((key[1][0]*a0 + key[1][1]*a1 + key[1][2]*a2 + key[0][3]*a3)%26 + 'A');
			char c2 = (char) ((key[2][0]*a0 + key[2][1]*a1 + key[2][2]*a2 + key[0][3]*a3)%26 + 'A');
			char c3 = (char) ((key[2][0]*a0 + key[2][1]*a1 + key[2][2]*a2 + key[0][3]*a3)%26 + 'A');
			
			result += c0 + "" + c1 + "" + c2 + "" + c3; 
		}
		
		return result;
	}
}
