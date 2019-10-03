package org.ziprange.util;

/**
 * ZipCodeRange is a pair of ZIP codes, low and high, representing an inclusive range of ZIP codes between.
 */
public class ZipCodeRange implements Comparable<ZipCodeRange> {

	private int low;
	private int high;

	ZipCodeRange(int low, int high) {
		// swap the values if necessary, to make a correct range
		if (high < low) {
			int realHigh = low;
			low = high;
			high = realHigh;
		}
		this.low = low;
		this.high = high;
	}

	int high() {
		return high;
	}

	int low() {
		return low;
	}

	@Override
	public String toString() {
		return "[" + low + "," + high + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ZipCodeRange) && (((ZipCodeRange) obj).high() == high())
				&& (((ZipCodeRange) obj).low() == low());
	}

	@Override
	public int hashCode() {
		// reasonably unique fast value
		return low();
	}

	@Override
	public int compareTo(ZipCodeRange that) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		if (this == that || this.equals(that))
			return EQUAL;

		if (low() < that.low || (low == that.low && high < that.high))
			return BEFORE;
		return AFTER;
	}
}
