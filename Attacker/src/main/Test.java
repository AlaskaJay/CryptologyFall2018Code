// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class Test {

	public static void main(String[] args) {
		int[][] test = {{1, 2}, {3, 4}};
		for(int i = 0; i < test.length; i++) {
			for(int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		int[][][] key2x2 = {
				{{2, 3}, {5, 7}}, 
				{{1, 4}, {6, 8}}};
		for(int i = 0; i < key2x2.length; i++) {
			for(int j = 0; j < key2x2[0].length; j++) {
				for(int k = 0; k < key2x2[0][0].length; k++) {
					System.out.print(key2x2[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
