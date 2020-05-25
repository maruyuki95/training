package training.yukicoder.no45.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sushiNum = sc.nextInt();
		int[] sushiTastes = new int[sushiNum];
		for (int i = 0; i < sushiNum; i++) {
			sushiTastes[i] = sc.nextInt();
		}

		int ret = new Main().execute(sushiTastes);
		System.out.println(ret);
	}

	int execute(int[] sushiTastes) {
		int lastOnMaxTasteSum = 0;
		int lastOffMaxTasteSum = 0;

		for (int taste : sushiTastes) {
			int newLastOnMaxTasteSum = lastOffMaxTasteSum + taste;
			int newLastOffMaxTasteSum = lastOnMaxTasteSum;

			lastOnMaxTasteSum = newLastOnMaxTasteSum;
			if (lastOffMaxTasteSum <= newLastOffMaxTasteSum) {
				lastOffMaxTasteSum = newLastOffMaxTasteSum;
			}

		}

		return Math.max(lastOnMaxTasteSum, lastOffMaxTasteSum);
	}

}
