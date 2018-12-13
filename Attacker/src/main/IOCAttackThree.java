// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class IOCAttackThree {

	public static void main(String[] args) {
		String message = "SBPRTLHMWWOAHHESCNQORWDPMUVZKGNDMAZAGENBBBASHYQEKUHWTBRXJOTIIAJHVPIWZKFOHCQPNHFPQQBAKZJXWHRVCYGGOKESLNCEKVFPHWGKDMTOMAGTZPNUNTLCMZKBSWOYDVGKYFLGXNXLCQOPRUUSLIMABAFZIURTLOYYBBLGFXPTNZWBPRIAJECCZIQBSBNZLUEHCECMFKKBPZLRJLCCZDRGDGNDMAZATTXARIJSENTBTYVTYLRTABECMBIWOYYMRVK";
		int[][] freq = new int[26][7];
		for(int i = 0; i < 7; i++) {
			String sub = IndexOfCoincidence.split(message, i, 7);
			int[] subFreq = IndexOfCoincidence.freqChart(sub);
			for(int j = 0; j < subFreq.length; j++) {
				freq[j][i] = subFreq[j];
			}
		}
		
		for(int i = 0; i < 26; i++) {
			System.out.print((char)('A'+i) + "| |");
		}
		System.out.println();
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 26; j++) {
				System.out.print((char)('A'+j) + "|" + freq[j][i] + "|");
			}
			for(int j = 0; j < 26; j++) {
				System.out.print((char)('A'+j) + "|" + freq[j][i] + "|");
			}
			System.out.println();
		}
	}

}
