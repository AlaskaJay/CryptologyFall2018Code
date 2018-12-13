// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class Main {
	public static void main(String[] args) {
		Encipherer e = new Encipherer();
		Decipherer d = new Decipherer();
		Attacker a = new Attacker();

		String message = "DOSVPJY XEA WK LOGKXMLSMPO RLTWCOJZ DENTJK UVCVXWPWKBNVO MPDTSWIU EWPUMPO YOF XGFY POXQ BML SSYA TM B QCBWPY EPL YOFR VIPPOK KB FA KTSVQPA NU B TTMXJSDMI VSHGZ";
		
		System.out.println(d.ceaser(message));
	}
}
