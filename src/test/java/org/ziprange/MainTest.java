package org.ziprange;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {

	@Test
	public void testEmpty() {
		Main.main(new String[0]);
		assertTrue("Maybe an error but didn't crash", true);
	}

	@Test
	public void testBadFormat() {
		Main.main(new String[] { "m" });
		assertTrue("Maybe an error but didn't crash", true);
	}

	@Test
	public void testNormalInput() {
		Main.main(new String[] { "[10000,20000]", "[20000,30000]" });
		assertTrue("Doesn't crash", true);
	}
}
