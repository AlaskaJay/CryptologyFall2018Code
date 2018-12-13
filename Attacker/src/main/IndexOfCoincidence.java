// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

import java.util.Scanner;

public class IndexOfCoincidence {
	public static void main(String[] augs) {
		String message = "SBPRTLHMWWOAHHESCNQORWDPMUVZKGNDMAZAGENBBBASHYQEKUHWTBRXJOTIIAJHVPIWZKFOHCQPNHFPQQBAKZJXWHRVCYGGOKESLNCEKVFPHWGKDMTOMAGTZPNUNTLCMZKBSWOYDVGKYFLGXNXLCQOPRUUSLIMABAFZIURTLOYYBBLGFXPTNZWBPRIAJECCZIQBSBNZLUEHCECMFKKBPZLRJLCCZDRGDGNDMAZATTXARIJSENTBTYVTYLRTABECMBIWOYYMRVK";
		Scanner key = new Scanner(System.in);
		System.out.print("Number to go up to? ");
		int times = key.nextInt();
		
		for(int i = 1; i <= times; i++) {
			double a = 0;
			for(int j = 0; j < i; j++) {
				String sub = split(message, j, i);
				double ioc = ioc(freqChart(sub), sub.length());
				System.out.println(i + ", " + j + ", " + ioc);
				a += ioc;
			}
			System.out.println("Average: " + a/i);
			System.out.println("FullStringIOC: " + ioc(freqChart(message), message.length()));
		}
	}
	
	public static String split(String s, int start, int skip) {
		String result = "";
		
		for(int i = start; i < s.length(); i+=skip) {
			result += s.charAt(i);
		}
		
		return result;
	}
	
	public static int[] freqChart(String s) {
		int[] result = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			result[s.charAt(i)-'A']++;
		}
		
		return result;
	}
	
	public static double ioc(int[] freq, int length) {
		double result = 0;
		
		for(int i = 0; i < freq.length; i++) {
			result += ioc(freq[i], length);
		}
		result *= 26;
		
		return result;
	}
	
	public static double ioc(int freq, int length) {
		return ((double)freq/(double)length)*((double)(freq-1)/(double)(length-1));
	}
}
