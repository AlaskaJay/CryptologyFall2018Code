// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.cipherers;

public interface Cipherer {
	public String caesarShift(String message, String key);
	public String caesarShift(String message, String key, boolean preserveSpacing, boolean preservePunct, boolean preserveCase);
	public String rot13(String message, String key);
	public String rot13(String message, String key, boolean preserveSpacing, boolean preservePunct, boolean preserveCase);
	public String veginere(String message, String key);
	public String veginere(String message, String key, boolean preserveSpacing, boolean preservePunct, boolean preserveCase);
	public String playfair(String message, String key);
	public String playfair(String message, String key, boolean preserveSpacing, boolean preservePunct, boolean preserveCase);
	// public String hill(String message, String key);
	// public String hill(String message, String key, boolean preserveSpacing, boolean preservePunct, boolean preserveCase);
	
	// TODO: polybius
	// TODO: ADFGVX
	// TODO: nihilist
	// TODO: bifid cipher
	// TODO: atbash
	// TODO: affine
	// TODO: lorenz
	// TODO: enigma
	// TODO: bilateral
}
