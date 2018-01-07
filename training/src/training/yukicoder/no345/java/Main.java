package training.yukicoder.no345.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		String arg = "alkunytaicvumkyawegmrxukikxwytyercevcjunwaiearinininininc";

		int ret = new Main().execute(arg);
		System.out.println(ret);
	}

	private int execute(String arg) {
		List<Integer> cIndexs = findIndexs(arg, "c");
		List<Integer> wIndexs = findIndexs(arg, "w");

		List<Integer> chiwawaLengths = findChiwawaLengths(cIndexs, wIndexs);

		Optional<Integer> minLength = chiwawaLengths.stream().min((a, b) -> a.compareTo(b));
		return minLength.orElse(-1);
	}

	private List<Integer> findIndexs(String origin, String target) {
		List<Integer> ret = new ArrayList<>();
		int i = 0;
		while (origin.indexOf(target, i) > -1) {
			int index = origin.indexOf(target, i);
			ret.add(index);
			i = index + 1;
		}
		return ret;
	}

	private List<Integer> findChiwawaLengths(List<Integer> cIndexs, List<Integer> wIndexs) {
		List<Integer> ret = new ArrayList<>();
		for (Integer cIndex : cIndexs) {
			int count = 0;
			for (Integer wIndex : wIndexs) {
				if(cIndex.compareTo(wIndex) > 0) {
					continue;
				}

				if(++count == 2) {
					ret.add(wIndex - cIndex + 1);
					break;
				}
			}
		}
		return ret;
	}
	
}
