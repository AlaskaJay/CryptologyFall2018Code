// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.ciphers;

public class Rot13 extends CaesarShift {

	public Rot13(String message, String key) {
		super(message, "13");
	}
}
