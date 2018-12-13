// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

import java.util.Scanner;

import main.cipherers.*;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		keyboard.useDelimiter("\n");
		System.out.println("This program expects you to give valid input. Failure to do so will result in termination.");
		try {
			System.out.print("Which cipher are you working with today?\n"
					+ "0: Caesar Shift\n"
					+ "1: Rot13\n"
					+ "2: Veginere\n"
					+ "3: Playfair\n"
					+ "Enter the num now: "); // TODO: add rest of the ciphers
			int cipher = keyboard.nextInt();
			
			System.out.print("Preserve case? (y/n) : ");
			boolean preserveCase = keyboard.next().equals("y");
			System.out.print("Preserve spacing? (y/n) : ");
			boolean preserveSpacing = keyboard.next().equals("y");
			System.out.print("Preserve punctuation? (y/n) : ");
			boolean preservePunct = keyboard.next().equals("y");
			System.out.print("Enciphering or deciphering? (e/d) : ");
			boolean enciphering = keyboard.next().equals("e");
			
			System.out.println(cipher + ", " + preserveCase + ", " + preserveSpacing + ", " + preservePunct + ", " + enciphering);
			
			System.out.print("Enter your message: ");
			String message = keyboard.next();
			
			System.out.print("Enter your key: ");
			String key = keyboard.next();

			Cipherer c = null; 
			
			if(enciphering) {
				c = new Encipherer();
			} else {
				c = new Decipherer();
			}
			
			if(cipher == 0) {
				System.out.println(c.caesarShift(message, key, preserveSpacing, preservePunct, preserveCase));
			} else if(cipher == 1) {
				System.out.println(c.rot13(message, key, preserveSpacing, preservePunct, preserveCase));
			} else if(cipher == 2) {
				System.out.println(c.veginere(message, key, preserveSpacing, preservePunct, preserveCase));
			} else if(cipher == 3) {
				System.out.println(c.playfair(message, key, preserveSpacing, preservePunct, preserveCase));				
			}
			
		} catch(Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		} finally {
			keyboard.close();
		}
	}
}
