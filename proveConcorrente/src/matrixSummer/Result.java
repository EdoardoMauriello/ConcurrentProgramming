package matrixSummer;

import java.util.Random;

public class Result {
	private final int[] results;
	private final int[][] matr;

	public Result(int[][] matr) {
		this.matr = matr;
		results = new int[matr.length];
	}

	public void setResult(int index, int value) {
		results[index] = value;
	}

	public void addResult(int index, int value) {
		results[index] += value;
	}

	public int getFinalResult() {
		int sum = 0;
		for (int i = 0; i < results.length; i++) {
			sum += results[i];
		}
		return sum;
	}

	public int[][] getMatr() {
		return matr;
	}

	public static void randFill(int[][] matr) {
		Random rand = new Random();
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				matr[i][j] = rand.nextInt(10);
			}
		}
	}

	public void printMatr() {
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				System.out.print(matr[i][j] + (j == matr[0].length - 1 ? "" : ", "));
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int[][] matr = new int[10][12];
		Result.randFill(matr);
		Result res = new Result(matr);

		for (int i = 0; i < matr.length; i++) {
			Summer s = new Summer(matr[i], i, res);
			s.join();
		}

		System.out.println("\nRisultato calcolato: " + res.getFinalResult());
		System.out.println("\nMatrice originale:");
		res.printMatr();

	}
}
