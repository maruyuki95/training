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
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
