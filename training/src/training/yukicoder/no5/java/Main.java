package training.yukicoder.no5.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int boxWidth = sc.nextInt();
		int blockNum = sc.nextInt();
		int[] blockWidths = new int[blockNum];
		for (int i = 0; i < blockNum; i++) {
			blockWidths[i] = sc.nextInt();
		}

		int ret = new Main().execute(boxWidth, blockNum, blockWidths);
		System.out.println(ret);
	}

	private int execute(int boxWidth, int blockNum, int[] blockWidths) {
		int[] sortedBlockWidths = blockWidths.clone();
		Arrays.parallelSort(sortedBlockWidths);

		int sumWidth = 0;
		for (int i = 0; i < sortedBlockWidths.length; i++) {
			sumWidth += sortedBlockWidths[i];
			if (boxWidth < sumWidth) {
				return i;
			}
		}

		return blockNum;
	}


}
