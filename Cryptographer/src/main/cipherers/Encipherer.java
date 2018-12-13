// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.cipherers;

import main.ciphers.*;

public class Encipherer implements Cipherer{
	
	@Override
	public String caesarShift(String message, String key) {
		return caesarShift(message, key, true, true, true);
	}

	@Override
	public String caesarShift(String message, String key, boolean preserveSpacing, boolean preservePunct,
			boolean preserveCase) {
		Cipher c = new CaesarShift(message, key);
		return c.encipher(preserveSpacing, preservePunct, preserveCase);
	}

	@Override
	public String rot13(String message, String key) {
		return rot13(message, key, true, true, true);
	}

	@Override
	public String rot13(String message, String key, boolean preserveSpacing, boolean preservePunct,
			boolean preserveCase) {
		Cipher c = new Rot13(message, key);
		return c.encipher(preserveSpacing, preservePunct, preserveCase);
	}

	@Override
	public String veginere(String message, String key) {
		return veginere(message, key, true, true, true);
	}

	@Override
	public String veginere(String message, String key, boolean preserveSpacing, boolean preservePunct,
			boolean preserveCase) {
		Cipher c = new Veginere(message, key);
		return c.encipher(preserveSpacing, preservePunct, preserveCase);
	}

	@Override
	public String playfair(String message, String key) {
		Cipher c = new Playfair(message, key);
		return c.encipher(true, true, true);
	}

	@Override
	public String playfair(String message, String key, boolean preserveSpacing, boolean preservePunct,
			boolean preserveCase) {
		Cipher c = new Playfair(message, key);
		return c.encipher(preserveSpacing, preservePunct, preserveCase);
	}

}
