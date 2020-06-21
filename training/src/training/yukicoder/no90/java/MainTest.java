package training.yukicoder.no90.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest extends Main {

	@Test
	public void test01() {
		int itemNum = 4;
		int[][] scoreTable = {
			{0, 1, 1},
			{0, 2, 2},
			{0, 3, 3},
			{1, 2, 4},
			{1, 3, 5},
			{2, 3, 6},
			{3, 2, 100},
			{2, 1, 100},
			{1, 0, 100},
			};
		
		assertEquals("300", calculateMaxScore(itemNum, scoreTable));
	}


}
