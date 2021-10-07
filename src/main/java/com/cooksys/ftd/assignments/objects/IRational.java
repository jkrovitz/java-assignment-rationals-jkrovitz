package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

interface IRational {

	/**
	 * @return the numerator of this rational number
	 */
	int getNumerator();

	/**
	 * @return the denominator of this rational number
	 */
	int getDenominator();

	/**
	 * Specializable constructor to take advantage of shared code between
	 * Rational and SimplifiedRational
	 * <p>
	 * Essentially, this method allows us to implement most of IRational methods
	 * directly in the interface while preserving the underlying type
	 *
	 * @param numerator
	 *            the numerator of the rational value to construct
	 * @param denominator
	 *            the denominator of the rational value to construct
	 * @return the constructed rational value
	 * @throws IllegalArgumentException
	 *             if the given denominator is 0
	 */
	IRational construct(int numerator, int denominator) throws IllegalArgumentException;

	/**
	 * negation of rational values
	 * <p>
	 * definition: `negate(n / d) = -n / d`
	 *
	 * @return the negation of this
	 */
	default IRational negate() {

		return construct(getNumerator() * -1, getDenominator());

	}

	/**
	 * inversion of rational values
	 * <p>
	 * definition: `invert(n / d) = d / n`
	 *
	 * @return the inversion of this
	 * @throws IllegalStateException
	 *             if the numerator of this rational value is 0
	 */
	default IRational invert() throws IllegalStateException {
		int n = getNumerator();
		int d = getDenominator();
		
		if (n == 0) {
			throw new IllegalStateException("The numerator cannot be 0 as the inversion would cause an error due to trying to divide by 0");
		}
		
		return construct(d, n);
	}

	/**
	 * addition of rational values
	 * <p>
	 * definition: `(n1 / d1) + (n2 / d2) = ((n1 * d2) + (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to add to this
	 * @return the sum of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational add(IRational that) throws IllegalArgumentException {
		
		if (that == null) {
			throw new IllegalArgumentException("that is null");
		}
		
		int n1 = getNumerator();
		int d1 = getDenominator();
		
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		if (d1 == 0 || d2 == 0) {
			throw new IllegalStateException("The numerator cannot be 0 as the inversion would cause an error due to trying to divide by 0");
		}
		
		int newDenominator = d1 * d2;
		int newNumeratorOwnFraction = n1 * d2;
		int newNumeratorElseFraction = n2 * d1;
		
		return construct(newNumeratorOwnFraction + newNumeratorElseFraction, newDenominator);
		
	}

	/**
	 * subtraction of rational values
	 * <p>
	 * definition: `(n1 / d1) - (n2 / d2) = ((n1 * d2) - (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to subtract from this
	 * @return the difference between this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational sub(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException("that is null");
		}
		
		int n1 = getNumerator();
		int d1 = getDenominator();
		
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		if (d1 == 0 || d2 == 0) {
			throw new IllegalStateException("The numerator cannot be 0 as the inversion would cause an error due to trying to divide by 0");
		}
		
		int newDenominator = d1 * d2;
		int newNumeratorOwnFraction = n1 * d2;
		int newNumeratorElseFraction = n2 * d1;
		
		return construct(newNumeratorOwnFraction - newNumeratorElseFraction, newDenominator);
	}

	/**
	 * multiplication of rational values
	 * <p>
	 * definition: `(n1 / d1) * (n2 / d2) = (n1 * n2) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to multiply this by
	 * @return the product of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational mul(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException("that is null");
		}
		
		int n1 = getNumerator();
		int d1 = getDenominator();
		
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		if (d1 == 0 || d2 == 0) {
			throw new IllegalStateException("The numerator cannot be 0 as the inversion would cause an error due to trying to divide by 0");
		}
		
		int newDenominator = d1 * d2;
		int newNumerator = n1 * n2;
		
		return construct(newNumerator, newDenominator);
	}

	/**
	 * division of rational values
	 * <p>
	 * definition: `(n1 / d1) / (n2 / d2) = (n1 * d2) / (d1 * n2)`
	 *
	 * @param that
	 *            the value to divide this by
	 * @return the ratio of this to that
	 * @throws IllegalArgumentException
	 *             if that is null or if the numerator of that is 0
	 */
	default IRational div(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException("that is null");
		}
		
		int n1 = getNumerator();
		int d1 = getDenominator();
		
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		if (d1 == 0 || d2 == 0) {
			throw new IllegalStateException("The numerator cannot be 0 as the inversion would cause an error due to trying to divide by 0");
		}
		
		int newNumeratorOwnFraction = n1 * d2;
		int newNumeratorElseFraction = d1 * n2;
		
		return construct(newNumeratorOwnFraction, newNumeratorElseFraction);
	}
}
