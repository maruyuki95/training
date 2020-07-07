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
		return canMakeWeight(weights, goalWeight);
	}

	private boolean canMakeWeight(int[] weights, int goalWeight) {
		Set<Integer> makableWeights = new HashSet<>();
		makableWeights.add(0);
		for (Integer weight : weights) {
			Set<Integer> additionalWeights = new HashSet<>(makableWeights);
			for (Integer makableWeight : makableWeights) {
				int additionalWeight = makableWeight + weight;
				if (additionalWeight == goalWeight) {
					return true;
				} else if (additionalWeight > goalWeight) {
					continue;
				} 
				additionalWeights.add(additionalWeight); 
			}
			makableWeights = additionalWeights;
		}
		return false;
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
