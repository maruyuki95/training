package training.yukicoder.no4.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		int[] weights = loadInputValue();
		outputResult(canDevideInHalf(weights));
	}

	private boolean canDevideInHalf(int[] weights) {
		int totalWeight = total(weights);
		if (totalWeight % 2 != 0) {
			return false;
		}

		int halfTotalWeight = totalWeight /2 ;
		return ;
	}

	private int total(int[] values) {
		int totalValue = 0;
		for (int value : values) {
			totalValue += value;
		}
		return totalValue;
	}

	@SuppressWarnings("resource")
	private int[] loadInputValue() {
		Scanner sc = new Scanner(System.in);
		int[] ret = new int[sc.nextInt()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = sc.nextInt();
		}
		return ret;
	}

	private void outputResult(boolean canDevideInHalf) {
		if (canDevideInHalf) {
			System.out.println("possible");
		} else {
			System.out.println("impossible");
		}
	}

}
