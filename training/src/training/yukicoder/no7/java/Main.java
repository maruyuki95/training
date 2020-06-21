package training.yukicoder.no7.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		int number = loadInputValue();
		outputResult(canFirstPlayerWin(number));
	}

	private static final int MIN_OF_PRIME_NUMBER = 2;
	private boolean canFirstPlayerWin(int number) {
		Set<Integer> primeNumbers = new HashSet<Integer>();
		Set<Integer> loseNumbers = new HashSet<Integer>();

		for (int i = MIN_OF_PRIME_NUMBER; i <= number; i++) {
			if (isPrimeNumber(i, primeNumbers)) {
				primeNumbers.add(i);
			}

			if (isLoseNumber(i, primeNumbers, loseNumbers)) {
				loseNumbers.add(i);
			}
		}

		if (loseNumbers.contains(number)) {
			return false;
		}
		return true;
	}

	private boolean isPrimeNumber(int targetNumber, Set<Integer> primeNumbers) {
		for (Integer primeNumber : primeNumbers) {
			if (targetNumber % primeNumber == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isLoseNumber(int targetNumber, Set<Integer> primeNumbers, Set<Integer> loseNumbers) {
		for (Integer primeNumber : primeNumbers) {
			int opponentNumber = targetNumber - primeNumber;
			if (loseNumbers.contains(opponentNumber)) {
				return false;
			}
		}
		return true;
	}

	private static final String WIN_FOR_DISPLAY = "Win";
	private static final String LOSE_FOR_DISPLAY = "Lose";
	private void outputResult(boolean canFirstPlayerWin) {
		if (canFirstPlayerWin) {
			System.out.println(WIN_FOR_DISPLAY);
		} else {
			System.out.println(LOSE_FOR_DISPLAY);
		}
	}

	@SuppressWarnings("resource")
	private int loadInputValue() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
