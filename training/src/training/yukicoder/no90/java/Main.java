package training.yukicoder.no90.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}

	@SuppressWarnings("resource")
	private void execute() {
		Scanner sc = new Scanner(System.in);
		int itemNum = sc.nextInt();
		int scoreTableLineCount = sc.nextInt();
		int[][] scoreTable = new int[scoreTableLineCount][3];
		for (int i = 0; i < scoreTableLineCount; i++) {
			scoreTable[i][0] = sc.nextInt();
			scoreTable[i][1] = sc.nextInt();
			scoreTable[i][2] = sc.nextInt();
		}

		int maxScore = calculateMaxScore(itemNum, scoreTable);
		output(maxScore);
	}

	int calculateMaxScore(int itemNum, int[][] scoreTable) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void output(int maxScore) {
		System.out.println(maxScore);
	}

}
