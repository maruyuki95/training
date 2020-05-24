package training.yukicoder.no45.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest extends Main {

	@Test
	public void test01() {
		int sushiNum = 4;
		int[] sushiTastes = {1, 2, 3, 4};
		final int ret = execute(sushiNum, sushiTastes);
		assertEquals(6, ret);
	}

	@Test
	public void test02() {
		int sushiNum = 4;
		int[] sushiTastes = {5, 4, 4, 9};
		final int ret = execute(sushiNum, sushiTastes);
		assertEquals(14, ret);
	}

	@Test
	public void test03() {
		int sushiNum = 7;
		int[] sushiTastes = {1, 2, 9, 10, 1, 1, 4};
		final int ret = execute(sushiNum, sushiTastes);
		assertEquals(16, ret);
	}

	@Test
	public void test04() {
		int sushiNum = 1;
		int[] sushiTastes = {100};
		final int ret = execute(sushiNum, sushiTastes);
		assertEquals(100, ret);
	}

}
