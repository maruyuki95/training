package training.yukicoder.no1.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cityNum = sc.nextInt();
		int money = sc.nextInt();
		int roadNum = sc.nextInt();

		List<Integer> cityS = new ArrayList<Integer>();
		for (int i = 0; i < roadNum; i++) {
			cityS.add(sc.nextInt());
		}

		List<Integer> cityT = new ArrayList<Integer>();
		for (int i = 0; i < roadNum; i++) {
			cityT.add(sc.nextInt());
		}

		List<Integer> costs = new ArrayList<Integer>();
		for (int i = 0; i < roadNum; i++) {
			costs.add(sc.nextInt());
		}

		List<Integer> times = new ArrayList<Integer>();
		for (int i = 0; i < roadNum; i++) {
			times.add(sc.nextInt());
		}

		int ret = new Main().execute(cityNum, money, roadNum, cityS, cityT, costs, times);
		System.out.println(ret);
	}

	private int execute(int cityNum, int money, int roadNum, List<Integer> cityS, List<Integer> cityT, List<Integer> costs, List<Integer> times) {
		searchRoute(1, cityNum, cityS, cityT, money, costs, 0, times);
		if(minTime == null) {
			return -1;
		}
		return minTime.intValue();
	}

	private Integer minTime = null;
	private void searchRoute(int location, int goal, List<Integer> cityS, List<Integer> cityT, int money, List<Integer> costs, int totalTime, List<Integer> times) {
		List<Integer> roadNums = filterRoadNumsWithLocation(cityS, location);		// 道の入り口が現在地と同じ道のみに絞る

		for (Integer roadNum : roadNums) {
			Integer cost = costs.get(roadNum);
			if (money < cost) {	// 資金が足りないのでスキップ
				continue;
			}

			int afterTime = totalTime + times.get(roadNum);
			if (minTime != null && minTime.intValue() <= afterTime) { // 既に最短時間よりも時間がかかっているためスキップ
				continue;
			}

			Integer afterLocation = cityT.get(roadNum);
			if (goal == afterLocation) {
				minTime = afterTime;
				continue;
			}else {	// 道の出口が目的地ではないため、再帰して探索
				int afterMoney = money - cost;
				searchRoute(afterLocation, goal, cityS, cityT, afterMoney, costs, afterTime, times);
			}
		}
	}

	private List<Integer> filterRoadNumsWithLocation(List<Integer> cityS, int location) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < cityS.size(); i++) {
			if (cityS.get(i) == location) {
				ret.add(i);
			}
		}
		return ret;
	}

}