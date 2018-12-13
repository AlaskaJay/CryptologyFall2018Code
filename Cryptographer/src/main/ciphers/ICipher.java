// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.ciphers;

public interface ICipher {	
	public String encipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase);
	public String decipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase);
}
