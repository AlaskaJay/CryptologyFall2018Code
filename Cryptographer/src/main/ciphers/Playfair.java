// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.ciphers;

import main.cipherers.StringManipulator;

public class Playfair extends Cipher{
	
	private char[][] trueKey;

	public Playfair(String message, String key) {
		super(message, key);
		assignTrueKey();
	}
	
	private void assignTrueKey() {
		trueKey = StringManipulator.polybiusKey(key);
	}
	
	public String encipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		String amend = message.charAt(0) + "";
		
		for(int i = 1; i < message.length(); i++) {
			if(message.toLowerCase().charAt(i) == message.toLowerCase().charAt(i-1)) {
				if(message.toLowerCase().charAt(i) == 'x') {
					amend+="i";
				} else {
					amend+="X";
				}
			}
			amend+=message.charAt(i);
		}
		
		String result = "";
		
		amend = StringManipulator.removePuncuation(amend);
		
		if(message.length()%2 != 0) {
			message+="X";
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(trueKey[i][j]);
			}
			System.out.println();
		}
		
		for(int i = 0; i < message.length(); i+=2) {
			int[][] hold = getLetterCoords(message.toUpperCase().charAt(i), message.toUpperCase().charAt(i+1));
			int x1 = hold[0][0];
			int y1 = hold[0][1];
			int x2 = hold[1][0];
			int y2 = hold[1][1];
			
			// System.out.println("Before: x1:" + x1 + ", y1:" + y1 + " for " + trueKey[x1][y1] + ", x2:" + x2 + ", y2:" + y2 + " for " + trueKey[x2][y2]);
			
			if (x1 == x2) {
				y1++;
				y2++;
				y1%=5;
				y2%=5;
			} else if (y1 == y2) {
				x1++;
				x2++;
				x1%=5;
				x2%=5;
			} else {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}

			// System.out.println("After:  x1:" + x1 + ", y1:" + y1 + " for " + trueKey[x1][y1] + ", x2:" + x2 + ", y2:" + y2 + " for " + trueKey[x2][y2]);
			
			result += trueKey[x1][y1];
			result += trueKey[x2][y2];
		}
		
		return result;
	}
	
	public String decipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		String result = "";
		
		message = StringManipulator.removePuncuation(message);
		
		if(message.length()%2 != 0) {
			message+="X";
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(trueKey[i][j]);
			}
			System.out.println();
		}
		
		for(int i = 0; i < message.length(); i+=2) {
			int[][] hold = getLetterCoords(message.toUpperCase().charAt(i), message.toUpperCase().charAt(i+1));
			int x1 = hold[0][0];
			int y1 = hold[0][1];
			int x2 = hold[1][0];
			int y2 = hold[1][1];
			
			// System.out.println("Before: x1:" + x1 + ", y1:" + y1 + " for " + trueKey[x1][y1] + ", x2:" + x2 + ", y2:" + y2 + " for " + trueKey[x2][y2]);
			
			if (x1 == x2) {
				y1--;
				y2--;
				if(y1 < 0) {
					y1 = 4;
				}
				if(y2 < 0) {
					y2 = 4;
				}
			} else if (y1 == y2) {
				x1--;
				x2--;
				if(x1 < 0) {
					x1 = 4;
				}
				if(x2 < 0) {
					x2 = 4;
				}
			} else {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}

			// System.out.println("After:  x1:" + x1 + ", y1:" + y1 + " for " + trueKey[x1][y1] + ", x2:" + x2 + ", y2:" + y2 + " for " + trueKey[x2][y2]);
			
			result += trueKey[x1][y1];
			result += trueKey[x2][y2];
		}
		
		return result;
	}
	
	public int[][] getLetterCoords(char a, char b) {
		int[][] coords = new int[2][2];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(trueKey[i][j] == a) {
					coords[0][0] = i;
					coords[0][1] = j;
				} else if(trueKey[i][j] == b) {
					coords[1][0] = i;
					coords[1][1] = j;
				}
			}
		}
		
		return coords;
	}
}
