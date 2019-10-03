package org.ziprange;

import java.util.List;
import java.util.stream.Collectors;

import org.ziprange.util.RangeListSimplifier;
import org.ziprange.util.ZipCodeParser;
import org.ziprange.util.ZipCodeRange;

/**
 * @author Kevin Fries Simplify expressions of multiple numeric ranges of ZIP
 *         codes
 */
public class Main {

	/**
	 * @param args String [] of value pairs inside brackets.  E.g.  [12345,23456] [12233.23344]
	 */
	public static void main(String[] args) {
		if (args.length == 0)
			System.err.println(
					"Enter space-separated pairs of ZIP codes, surrounded by brackets.  E.g. [94133,94133] [94200,94299] [94600,94699]");


		List<ZipCodeRange> simplified = simplifyRangeSet(args);
		System.out.println(simplified.stream().map(ZipCodeRange::toString).collect(Collectors.joining(" ")));
	}

	private static List<ZipCodeRange> simplifyRangeSet(String[] args) {
		List<ZipCodeRange> ranges = ZipCodeParser.parse(args);
		return RangeListSimplifier.simplifyRanges(ranges);
	}
}
