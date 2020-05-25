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

		int ret = new Main().execute(sushiNum, sushiTastes);
		System.out.println(ret);
	}

	int execute(int sushiNum, int[] sushiTastes) {
		int lastOnMaxTasteSum = 0;
		int lastOffMaxTasteSum = 0;
		boolean lastOff = true;

		for (int taste : sushiTastes) {
			if (lastOff) {
				lastOnMaxTasteSum = lastOffMaxTasteSum + taste;
				lastOff = false;
			} else {
				int newLastOnMaxTasteSum = lastOffMaxTasteSum + taste;
				int newLastOffMaxTasteSum = lastOnMaxTasteSum;

				lastOnMaxTasteSum = newLastOnMaxTasteSum;
				lastOffMaxTasteSum = newLastOffMaxTasteSum;

				if (lastOnMaxTasteSum <= lastOffMaxTasteSum) {
					lastOff = true;
				}
			}

		}

		return Math.max(lastOnMaxTasteSum, lastOffMaxTasteSum);
	}

}
