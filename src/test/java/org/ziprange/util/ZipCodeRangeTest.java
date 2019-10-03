package org.ziprange.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ZipCodeRangeTest {

	/**
	 * test basic creation values
	 */
	@Test
	public void testCreationValues() {
		int low = 0;
		int high = 1000;
		ZipCodeRange pair = new ZipCodeRange(low, high);
		assertEquals("Low must be retrieved", pair.low(), low);
		assertEquals("High must be retrieved", pair.high(), high);
	}

	@Test
	public void testCreationValuesReversed() {
		int low = 10000;
		int high = 20000;
		ZipCodeRange pair = new ZipCodeRange(high, low);
		assertEquals("Low  is the lower value", pair.low(), low);
		assertEquals("High is the high value", pair.high(), high);
	}
	@Test
	public void testSorting() {
		int low = 0;
		int high = 1000;
		ZipCodeRange one = new ZipCodeRange(low, high);
		ZipCodeRange two = new ZipCodeRange(low, high + 1);
		ZipCodeRange three = new ZipCodeRange(low + 1, high);
		ZipCodeRange four = new ZipCodeRange(low + 1, high + 1);
		List<ZipCodeRange> listToSort = Arrays.asList(four, three, two, one);
		Collections.sort(listToSort);
		assertEquals("Should be sorted", listToSort, Arrays.asList(one, two, three, four));
	}
}
