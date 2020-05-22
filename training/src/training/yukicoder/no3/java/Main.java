package training.yukicoder.no3.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arg = sc.nextInt();
		int ret = new Main().execute(arg);
		System.out.println(ret);
	}

	private int execute(int goal) {
		Set<Integer> locations = new HashSet<Integer>();
		locations.add(1);
		return search(goal, locations, locations, 1);
	}

	private int search(int goal, Set<Integer> passedLocations, Set<Integer> diffLocations, int times) {
		if (diffLocations.contains(goal)) {
			return times;
		}

		Set<Integer> newLocations = new HashSet<Integer>();
		for (Integer location : diffLocations) {
			int binaryTotal = calcurateBinaryTotal(location);

			int locationForward = location + binaryTotal;
			if (isMovedToNewLocation(goal, passedLocations, locationForward)) {
				newLocations.add(locationForward);
			}

			int locationBackward = location - binaryTotal;
			if (isMovedToNewLocation(goal, passedLocations, locationBackward)) {
				newLocations.add(locationBackward);
			}
		}

		if (newLocations.size() > 0) {
			passedLocations.addAll(newLocations);
			return search(goal, passedLocations, newLocations, ++times);
		}

		return -1;
	}

	private boolean isMovedToNewLocation(int goal, Set<Integer> passedLocations, int location) {
		return 1 <= location && location <= goal && !passedLocations.contains(location);
	}

	/**
	 * 10進数の数値を2進数で表現した時の1のビット数を返す
	 * @param decimalNumber	10進数
	 * @return	2進数で表現した時の1のビット数
	 */
	private int calcurateBinaryTotal(int decimalNumber) {
		int ret = 0;
		int quotient = decimalNumber;
		do {
			ret += quotient % 2;
			quotient = quotient / 2;
		} while (quotient > 0);

		return ret;
	}

}
