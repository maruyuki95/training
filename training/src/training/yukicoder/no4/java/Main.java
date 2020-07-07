package training.yukicoder.no4.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

		int goalWeight = totalWeight / 2;
		int remainingWeight = totalWeight;
		List<Integer> sortedWeights = convertToSortedList(weights);
		Set<Integer> availavleWeights = new HashSet<>();
		availavleWeights.add(0);
		for (Integer weight : sortedWeights) {
			remainingWeight -= weight;
			
			Set<Integer> additionalWeights = new HashSet<>(availavleWeights);
			for (Integer availavleWeight : availavleWeights) {
				int e = availavleWeight + weight;
				if (e == goalWeight) {
					return true;
				} else if (e > goalWeight) {
					continue;
				} else if (e + remainingWeight < goalWeight) {
					continue;
				}
				additionalWeights.add(e); 
			}
			availavleWeights = additionalWeights;
		}
		
		return false;
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
