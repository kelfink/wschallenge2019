package org.ziprange.util;

import java.util.ArrayList;
import java.util.List;

/**
 *  ZipCodeParser utility class parses an array of zip code pairs (format "NNNNN,MMMMM")
 * 	into a list of ZipCodeRange objects for analysis.
 */
public class ZipCodeParser {

	/**
	 * Parse an array of zipcode range strings (e.g. ["11111,22222", "33333,44444"] )
	 * returns a java.util.List of ZipCodeRange objects parsed.  Ignores invalid ranges, emitting System.err values when
	 * invalid ranges are encountered.
	 * @param zipRangeStrings String []
	 * @return java.util.List<ZipCodeRange>
	 */
	public static List<ZipCodeRange> parse(String[] zipRangeStrings) {
		ArrayList<ZipCodeRange> ranges = new ArrayList<>();
		for (String rangeString : zipRangeStrings)
			if (!validateFormat(rangeString))
				System.err.println("Range string " + rangeString + " is in an invalid format.  Use [nnnnn,nnnnn]");
			else
				ranges.add(parseRangeString(rangeString));
		return ranges;
	}

	private static boolean validateFormat(String rangeString) {
		return rangeString.matches("\\[[0-9]{5},[0-9]{5}]");
	}

	/**
	 * Parse a single range from an input string in the form [xxx,yyy] If the
	 * first value is higher than the second, flip them to make a proper range.
	 * 
	 * @param rangeString String
	 * @return ZipCodeRange
	 */
	private static ZipCodeRange parseRangeString(String rangeString) {
		String[] valuesWithBracketsParsed = rangeString.split("[\\[\\]]");
		String[] lowAndHighValues = valuesWithBracketsParsed[1].split(",");
		int lowEnd = Integer.parseInt(lowAndHighValues[0]);
		int highEnd = Integer.parseInt(lowAndHighValues[1]);
		return highEnd >= lowEnd ? new ZipCodeRange(lowEnd, highEnd) : new ZipCodeRange(highEnd, lowEnd);
	}
}
