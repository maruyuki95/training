package training.yukicoder.no2.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest extends Main {

	@Test
	public void test01() {
		assertEquals("Alice", judgeWinner(4));
	}

	@Test
	public void test02() {
		assertEquals("Alice", judgeWinner(11));
	}

	@Test
	public void test03() {
		assertEquals("Alice", judgeWinner(24));
	}

	@Test
	public void test04() {
		assertEquals("Bob", judgeWinner(600));
	}

	@Test
	public void testMax() {
		assertEquals("Bob", judgeWinner(100000000));
	}

	@Test
	public void test_system5() {
		assertEquals("Alice", judgeWinner(25670140));
	}

}
