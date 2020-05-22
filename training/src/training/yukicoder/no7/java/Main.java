package training.yukicoder.no7.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arg = sc.nextInt();
		String ret = new Main().execute(arg);
		System.out.println(ret);
	}

	private String execute(int number) {
		Set<Integer> primaries = new HashSet<Integer>();
		Set<Integer>  loseNumbers = new HashSet<Integer>();

		for (int i = 2; i <= number; i++) {
			if (isPrimaryNumber(i, primaries)) {
				primaries.add(i);
			}

			if (isLoseNumber(i, primaries, loseNumbers)) {
				loseNumbers.add(i);
			}
		}

		if (loseNumbers.contains(number)) {
			return "Lose";
		}
		return "Win";
	}

	private boolean isPrimaryNumber(int i, Set<Integer> primaries) {
		for (Integer primary : primaries) {
			if (i % primary == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isLoseNumber(int targetNumber, Set<Integer> primaries, Set<Integer> loseNumbers) {
		for (Integer primary : primaries) {
			if (loseNumbers.contains(targetNumber - primary)) {
				return false;
			}
		}
		return true;
	}

}
