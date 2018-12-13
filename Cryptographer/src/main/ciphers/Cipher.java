// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.ciphers;

public class Cipher implements ICipher{
	protected String message;
	protected String key;
	
	public Cipher(String message, String key) {
		this.message = message;
		this.key = key;
	}

	@Override
	public String encipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decipher(boolean preserveSpacing, boolean preservePunct, boolean preserveCase) {
		// TODO Auto-generated method stub
		return null;
	}

}
