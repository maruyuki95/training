package training.yukicoder.no90.java;

import java.util.ArrayList;
import java.util.List;
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
		// scoreTableをループする
		// リストにない番号が出てきたらリストに追加
		// ２つの番号ともリストに含まれてて、その順序が得点になるなら、順序はそのまま
		// ２つの番号ともリストに含まれてて、その順序が得点にならないなら、順序を並び替えて、最高得点になる順序にその２つの番号の順序を変える

		List<Integer> maxScoreSortedItems = new ArrayList<Integer>();
		int maxScore = 0;
		for (int i = 0; i < scoreTable.length; i++) {
			int[] scoreArray = scoreTable[i];
			int forwardItem = scoreArray[0];
			int backwardItem = scoreArray[1];

			int forwardItemIndex = maxScoreSortedItems.indexOf(forwardItem);
			int backwardItemIndex = maxScoreSortedItems.indexOf(backwardItem);

			if (forwardItemIndex == -1) {
				maxScoreSortedItems.add(0, forwardItemIndex);
				maxScore = calculateScore(maxScoreSortedItems, scoreTable, i);
			}

			if (backwardItemIndex == -1) {
				maxScoreSortedItems.add(backwardItemIndex);
			}

			if (forwardItemIndex == -1 || backwardItemIndex == -1) {
				maxScore = calculateScore(maxScoreSortedItems, scoreTable, i);
			} else if (forwardItemIndex > backwardItemIndex) {
				// 最高得点になるよう順序を並び替え
				// forwardの位置固定→backwardをforwardより後ろの位置にしていく
				List<Integer> backwardRemovedItems = new ArrayList<>(maxScoreSortedItems);
				backwardRemovedItems.remove(backwardItemIndex);
				int n = backwardRemovedItems.indexOf(forwardItem);
				while (++n < backwardRemovedItems.size()) {
					List<Integer> targetItems = new ArrayList<>(backwardRemovedItems);
					targetItems.add(n, backwardItem);
					int score = calculateScore(targetItems, scoreTable, i);
					if (score > maxScore) {
						maxScore = score;
						maxScoreSortedItems = targetItems;
					}
				}

				// backwardの位置固定→forwardをbackwardより前の位置にしていく
				List<Integer> forwardRemovedItems = new ArrayList<>(maxScoreSortedItems);
				forwardRemovedItems.remove(forwardItemIndex);
				int m = 0;
				while (++m <= backwardItemIndex) {
					List<Integer> targetItems = new ArrayList<>(forwardRemovedItems);
					targetItems.add(m, forwardItem);
					int score = calculateScore(targetItems, scoreTable, i);
					if (score > maxScore) {
						maxScore = score;
						maxScoreSortedItems = targetItems;
					}
				}
			}
		}

		return maxScore;
	}

	private int calculateScore(List<Integer> maxScoreSortedItems, int[][] scoreTable, int i) {
		// TODO Auto-generated method stub
		// 対象の順番のリストを、i番目までの得点表で得点計算する
		return 0;
	}

	private void output(int maxScore) {
		System.out.println(maxScore);
	}

}
