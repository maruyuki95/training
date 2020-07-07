package training.yukicoder.no4.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainTest extends Main {

	@Test
	public void test01() {
		int[] weights = {1, 2, 3};
		assertTrue(canDevideInHalf(weights));
	}

	@Test
	public void test02() {
		int[] weights = {1, 2, 3, 4, 5};
		assertFalse(canDevideInHalf(weights));
	}

	@Test
	public void test03() {
		int[] weights = {62, 8, 90, 2, 24, 62, 38, 64, 76, 60, 30, 76, 80, 74, 72};
		assertFalse(canDevideInHalf(weights));
	}

	@Test
	public void testSystem08() {
		int[] weights = {
				16, 100, 48, 18, 62, 46, 90, 58, 48, 20,
				82, 32, 86, 86, 76, 8, 56, 60, 82, 26, 
				8, 40, 20, 16, 22, 68, 100, 58, 34, 72,
				96, 54, 26, 36, 22, 68, 60, 100, 60, 44,
				36, 46, 88, 74, 72, 92, 58, 84, 90, 16, 
				4, 8, 18, 90, 38, 82, 50, 94, 62, 8, 
				46, 34, 100, 50, 4, 8, 56, 18, 58, 68,
				98, 64, 72, 28, 32, 30, 28, 74, 52, 40,
				32, 90, 60, 4, 36, 92, 12, 10, 4, 98, 78, 
				48, 12, 66, 6, 34, 34, 76, 78, 90
};
		assertFalse(canDevideInHalf(weights));
	}

	@Test
	public void testMany() {
		int[] weights = new int[100];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = i + 1;
		}
		assertTrue(canDevideInHalf(weights));
	}

	@Test
	public void testMaru() {
		int[] weights = {5, 5, 5, 3, 3, 3, 3, 3};
		assertTrue(canDevideInHalf(weights));
	}

}

