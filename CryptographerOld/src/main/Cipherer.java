// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public interface Cipherer {
	public String createWordShiftKey(String key);
	public char[][] polybiusKey(String key);
	public String polybius(String message, String key);
	public String shift(String message, String key);
	public String ceaser(String message);
	public String ceaser(String message, String key);
	public String ceaser(String message, char key);
	public String ceaser(String message, int key);
	public String rot13(String message);
	public String atbash(String message);
	//public String affine(String message);
	//public String vigenere(String message, String key);
}
