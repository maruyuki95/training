package training.yukicoder.no2.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static final String FIRST_PLAYER_NAME = "Alice";
	private static final String SECOND_PLAYER_NAME = "Bob";
	private static final int MIN_PRIME = 2;

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		int number = loadInputValue();
		String winnerName = judgeWinner(number);
		outputResult(winnerName);
	}

	String judgeWinner(int number) {
		Map<Integer, Integer> primeFactorizationMap = calculatePrimeFactorization(number, MIN_PRIME);

		if (isFirstPlayerWinner(primeFactorizationMap)) {
			return FIRST_PLAYER_NAME;
		}
		return SECOND_PLAYER_NAME;
	}

	/**
	 * 素因数分解する
	 * @param number	素因数分解する数	(e.g.)24
	 * @param minCheckingPrime	素因数かどうかチェックし始める素数の最小値	(e.g.)2
	 * @return keyに素因数、valueにその指数を保持するMap	(e.g.) {2=3, 3=1}
	 */
	private Map<Integer, Integer> calculatePrimeFactorization(int number, int minCheckingPrime) {
		if (number == 1) {
			return new HashMap<Integer, Integer>();
		}

		for (int i = minCheckingPrime; i <= number; i++) {
			if (number % i == 0) {
				Map<Integer, Integer> primeFactorizationMap = calculatePrimeFactorization(number / i, i);

				Integer exponent = primeFactorizationMap.get(i);
				if (exponent == null) {
					exponent = 0;
				}
				primeFactorizationMap.put(i, ++exponent);
				return primeFactorizationMap;
			}

		}
		throw new IllegalStateException("対象の数値「" + number + "」には約数が存在しません。");
	}

	private boolean isFirstPlayerWinner(Map<Integer, Integer> primeFactorizationMap) {
		return isFirstPlayerWinnerRecursively(new ArrayList<Integer>(primeFactorizationMap.values()));
	}

	private boolean isFirstPlayerWinnerRecursively(List<Integer> exponents) {
		if (exponents.size() == 0) {
			return false;
		}
		if (exponents.size() == 1) {
			return true;
		}

		Integer exponentValue1 = exponents.remove(0);
		Integer exponentValue2 = exponents.remove(0);
		if (exponentValue1 != exponentValue2) {
			exponents.add(Math.abs(exponentValue1 - exponentValue2));
		}
		return isFirstPlayerWinnerRecursively(exponents);
	}

	@SuppressWarnings("resource")
	private int loadInputValue() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private void outputResult(String result) {
		System.out.println(result);
	}

}
