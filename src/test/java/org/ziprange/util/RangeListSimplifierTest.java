package org.ziprange.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RangeListSimplifierTest {

	@Test
	public void testRangeSimplifierOneRange() {
		ZipCodeRange[] ranges = { new ZipCodeRange(10000, 20000) };
		List<ZipCodeRange> listRanges = Arrays.asList(ranges);
		assertEquals(listRanges, RangeListSimplifier.simplifyRanges(listRanges));
	}

	@Test
	public void testRangeSimplifierSortedAndMerged() {
		ZipCodeRange[] ranges = { new ZipCodeRange(30000, 40000), new ZipCodeRange(20000, 30000) };
		ZipCodeRange[] rangesSimplified = { new ZipCodeRange(20000, 40000) };

		assertEquals("Should sort and merge these two zipcode ranges", Arrays.asList(rangesSimplified),
				RangeListSimplifier.simplifyRanges(Arrays.asList(ranges)));
	}

	@Test
	public void testRangeSimplifierLeftAloneWhenNotOverlapping() {
		ZipCodeRange[] ranges = { new ZipCodeRange(10000, 20000), new ZipCodeRange(30000, 40000) };

		assertEquals("Should leave this list alone.", Arrays.asList(ranges),
				RangeListSimplifier.simplifyRanges(Arrays.asList(ranges)));
	}

	@Test
	public void testChallengeFirstSampleValue() {
		ZipCodeRange[] ranges = { new ZipCodeRange(94133, 94133), new ZipCodeRange(94200, 94299),
				new ZipCodeRange(94600,94699)};

		assertEquals("matches specification example.", Arrays.asList(ranges),
				RangeListSimplifier.simplifyRanges(Arrays.asList(ranges)));
	}

	@Test
	public void testChallengeSecondSampleValue() {
		ZipCodeRange[] ranges = { new ZipCodeRange(94133, 94133), new ZipCodeRange(94200, 94299),
				new ZipCodeRange(94226, 94399)};

		ZipCodeRange[] rangesOutput = { new ZipCodeRange(94133, 94133), new ZipCodeRange(94200, 94399)};
		assertEquals("matches specification example.", Arrays.asList(rangesOutput),
				RangeListSimplifier.simplifyRanges(Arrays.asList(ranges)));
	}
}