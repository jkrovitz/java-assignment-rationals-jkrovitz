package com.cooksys.ftd.assignments.objects;

import java.util.Objects;

public class Rational implements IRational {
    private int numerator;
    private int denominator;
    private double rational;

	/**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
//      throw new NotImplementedException();
    	this.numerator = numerator;
    	this.denominator = denominator;
    	
    	if (this.denominator == 0) {
    		throw new IllegalArgumentException();
    	}
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
//        throw new NotImplementedException();
    	return numerator;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
//        throw new NotImplementedException();
    	return denominator;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0) {
    		throw new IllegalArgumentException();
    	}
    	Rational rational = new Rational(numerator, denominator);
    	return rational;
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     * 
     * Referenced https://introcs.cs.princeton.edu/java/92symbolic/Rational.java.html to help me solve this problem.
     */
    @Override
    public boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	if (obj.getClass() != this.getClass()) {
    		return false;
    	}
    	Rational b = (Rational) obj;
    	Rational a = this;
    	int lhs = a.numerator * b.denominator;
    	int rhs = a.denominator * b.numerator;
    	if (lhs < rhs)  {
    		return false;
    	}
    	if (lhs > rhs) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
        if ((getNumerator() < 0 && getDenominator() > 0)  || (getNumerator() > 0 && getDenominator() < 0)) {
//    	if ((getNumerator() / getDenominator()) > 0) {
        	int numeratorAbs = Math.abs(getNumerator());
        	int denominatorAbs = Math.abs(getDenominator());
        	return "-" + numeratorAbs + "/" + denominatorAbs;
        }
        else {
        	int numeratorAbs = Math.abs(getNumerator());
        	int denominatorAbs = Math.abs(getDenominator());
        	return numeratorAbs + "/" + denominatorAbs;
        }
    }

}
