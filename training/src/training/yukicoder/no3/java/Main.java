package training.yukicoder.no3.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arg = sc.nextInt();
		int ret = new Main().execute(arg);
		System.out.println(ret);
	}

	private int execute(int goal) {
		List<Integer> routes = new ArrayList<Integer>();
		searchRoute(1, goal, routes);
		if (moveMin == null) {
			return -1;
		}
		return moveMin.intValue();
	}

	private Integer moveMin = null;
	private void searchRoute(int location, int goal, List<Integer> routes) {
		List<Integer> afterRoutes = new ArrayList<Integer>(routes);
 		afterRoutes.add(location);

		if (location == goal) {
			if (moveMin == null || afterRoutes.size() < moveMin.intValue()) {
				moveMin = afterRoutes.size();
			}
			return ;
		}

		int binaryTotal = calcurateBinaryTotal(location);

		int locationForward = location + binaryTotal;
		if (canMove(goal, afterRoutes, locationForward)) {
			searchRoute(locationForward, goal, afterRoutes);
		}

		int locationBackward = location - binaryTotal;
		if (canMove(goal, afterRoutes, locationBackward)){
			searchRoute(locationBackward, goal, afterRoutes);
		}
	}

	private boolean canMove(int goal, List<Integer> routes, int location) {
		return 1 <= location && location <= goal && !routes.contains(location);
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
