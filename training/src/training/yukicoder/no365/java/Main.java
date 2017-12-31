package training.yukicoder.no365.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	private static final String SEPARATE = " ";

	public static void main(String[] args) {
		String arrayStr = "4 3 2 1";
		int ret = new Main().execute(arrayStr);
		System.out.println(ret);
	}

	public int execute(String arrayStr) {
		String[] strings = arrayStr.split(SEPARATE);

		List<Integer> originInts = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			String string = strings[i];
			originInts.add(new Integer(string));
		}
		
		List<Integer> sortedInts = new ArrayList<>(originInts);
		Collections.sort(sortedInts, Collections.reverseOrder());

		List<Integer> reversedInts = new ArrayList<>(originInts);
		Collections.reverse(reversedInts);

		for (Integer integer : reversedInts) {
			if(integer.equals(sortedInts.get(0))) {
				sortedInts.remove(0);
			}
		}
		return sortedInts.size();
	}
}
