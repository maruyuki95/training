package training.yukicoder.no4.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		int[] weights = loadInputValue();
		outputResult(canDevideInHalf(weights));
	}

	boolean canDevideInHalf(int[] weights) {
		int totalWeight = total(weights);
		if (totalWeight % 2 != 0) {
			return false;
		}

		int halfTotalWeight = totalWeight /2 ;
		startTime = System.currentTimeMillis();
		return canMakeWeight(convertToSortedList(weights), halfTotalWeight);
	}

	private long startTime = 0;
	private long removeTime = 0;
	private boolean canMakeWeight(List<Integer> weights, int goalWeight) {
		List<Integer> copyList = new ArrayList<>(weights);
		
		for (Integer weight : weights) {
			if (weight == goalWeight) {
				return true;
			} 
			
			int sum = summary(copyList);
			if (sum < goalWeight) {
				return false;
			}
			
			long removeStart = System.currentTimeMillis();
			copyList.remove(weight);
			removeTime += System.currentTimeMillis() - removeStart;
			if (weight > goalWeight) {
				continue;
			}
			
			if (canMakeWeight(copyList, goalWeight - weight)) {
				return true;
			}
		}
		System.out.println(100 * removeTime / (System.currentTimeMillis() - startTime));
		return false;
	}

	private int summary(List<Integer> list) {
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		return sum;
	}

	private List<Integer> convertToSortedList(int[] array) {
		List<Integer> ret = new ArrayList<>();
		for (int i : array) {
			ret.add(i);
		}
		Collections.sort(ret);
		return ret ;
	}
	
	private int total(int[] values) {
		int totalValue = 0;
		for (int value : values) {
			totalValue += value;
		}
		return totalValue;
	}

	@SuppressWarnings("resource")
	private int[] loadInputValue() {
		Scanner sc = new Scanner(System.in);
		int[] ret = new int[sc.nextInt()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = sc.nextInt();
		}
		return ret;
	}

	private void outputResult(boolean canDevideInHalf) {
		if (canDevideInHalf) {
			System.out.println("possible");
		} else {
			System.out.println("impossible");
		}
	}

}
