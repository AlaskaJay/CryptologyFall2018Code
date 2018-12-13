// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class IOCAttackTwo {

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
		
		for(int i = 0; i < freq.length; i++) {
			System.out.print((char)('A'+i) + ": ");
			for(int j = 0; j < freq[i].length; j++) {
				System.out.print(freq[i][j] + " ");
			}
			System.out.println();
		}
	}

}
