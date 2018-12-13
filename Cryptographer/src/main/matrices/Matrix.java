// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main.matrices;

public class Matrix {
	private int[][] model;

	public Matrix() {
		
	}
	
	public Matrix(int[][] model) {
		this.model = model;
	}
	
	public int getWidth() {
		return model.length;
	}
	
	public int getHeight() {
		return model[0].length;
	}
	
	public void scalarMultiplication(double multiplier) {
		for(int i = 0; i < model.length; i++) {
			for(int j = 0; j < model[0].length; j++) {
				model[i][j] *= multiplier;
			}
		}
	}
	
	public void matrixMultiplication(Matrix other) {
		
	}
	
	public void matrixAddition(Matrix other) {
		
	}
}
