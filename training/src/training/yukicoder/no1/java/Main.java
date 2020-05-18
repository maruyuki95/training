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

	private int execute(int cityNum, int money, int roadNum, List<Integer> cityS, List<Integer> cityT,
			List<Integer> costs, List<Integer> times) {

		// 目的地にたどり着く経路を検索
		List<Integer> routes = new ArrayList<Integer>();
		List<List<Integer>> compRoutes = new ArrayList<List<Integer>>();
		searchRoute(1, cityNum, cityS, cityT, routes, compRoutes, money, costs);

		if(compRoutes.isEmpty()) {
			return -1;
		}

		// 経路のうち最短時間を計算する
		return calcurateMinTime(compRoutes, times);
	}

	private void searchRoute(int location, int goal, List<Integer> cityS, List<Integer> cityT, List<Integer> routes, List<List<Integer>> compRoutes, int money, List<Integer> costs) {
		for (int i = 0; i < cityS.size(); i++) {
			int start = cityS.get(i);
			if (start != location) {	// 道の入り口が現在地と異なるのでスキップ
				continue;
			}

			Integer cost = costs.get(i);
			if (money < cost) {	// 資金が足りないのでスキップ
				continue;
			}

			List<Integer> newRoutes = new ArrayList<Integer>(routes);
			newRoutes.add(i);
			if (goal == cityT.get(i)) {	// 目的地にたどり着いたのでcompに入れて再探索
				compRoutes.add(newRoutes);
				continue;
			}else {	// 道の出口が目的地ではないため、再帰して探索
				int newMoney = money - cost;
				searchRoute(cityT.get(i), goal, cityS, cityT, newRoutes, compRoutes, newMoney, costs);
			}
		}
	}

	private int sumAmountWithRoute(List<Integer> route, List<Integer> values) {
		int ret = 0;
		for (Integer roadNum : route) {
			ret += values.get(roadNum);
		}
		return ret;
	}

	private int calcurateMinTime(List<List<Integer>> filteredByMoneyRoutes, List<Integer> times) {
		if (filteredByMoneyRoutes == null || filteredByMoneyRoutes.isEmpty()) {
			throw new IllegalArgumentException("No routes.");
		}

		Integer minTime = null;
		for (List<Integer> route : filteredByMoneyRoutes) {
			int totalTime = sumAmountWithRoute(route, times);
			if (minTime == null || totalTime < minTime.intValue()) {
				minTime = totalTime;
			}
		}

		return minTime.intValue();
	}


}