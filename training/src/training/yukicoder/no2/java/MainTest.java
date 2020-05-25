package training.yukicoder.no2.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest extends Main {

	@Test
	public void test01() {
		assertEquals("Alice", execute(4));
	}

	@Test
	public void test02() {
		assertEquals("Alice", execute(11));
	}

	@Test
	public void test03() {
		assertEquals("Alice", execute(24));
	}

	@Test
	public void test04() {
		assertEquals("Bob", execute(600));
	}

	@Test
	public void testMax() {
		assertEquals("Bob", execute(100000000));
	}

}
