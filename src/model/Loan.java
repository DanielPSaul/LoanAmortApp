/**
 * 
 */
package model;

/**
 * @author craigpiercy
 * This class will model a basic loan
 */
public class Loan {
	
	// declare private instance variables
	private double principal;
	private double rate; // assume that this is APR enter like 6.0 for 6%
	private int term;  // assume that this is years
	
	/**
	 * a default constructor - when called this will create an empty loan object
	 */
	public Loan() {

	}
	
	/**
	 * @param principal
	 * @param rate
	 * @param term
	 * an optional (overloaded) constructor - when called this will create a
	 * loan object that includes the values that are passed to it
	 */
	public Loan(double principal, double rate, int term) {
		this.principal = principal;
		this.rate = rate;
		this.term = term;
	}
	
	// public getters and setters - allows a 'user' to access or modify the instance variables

	/**
	 * @return the principal
	 */
	public double getPrincipal() {
		return principal;
	}

	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Creates a standard String description of the object
	 */
	@Override
	public String toString() {
		return "Loan [principal=" + principal + ", rate=" + rate + ", term="
				+ term + "]";
	}
	
	/*
	 * This method will provide the monthly rate = APR/12/100
	 */
	public double getMonthlyRate(){
		return this.getRate() / 12 / 100;
	}
	
	/*
	 * This method will provide the total months = years*12
	 */
	public int getMonths(){
		return this.getTerm()*12;
	}
	
	/*
	 * This method will provide the monthly payment for the loan
	 */
	public double getMonthlyPayment(){
		return this.getPrincipal() * this.getMonthlyRate() / ( 1 - Math.pow( 1 + this.getMonthlyRate(), -this.getMonths()));
	}
	

}
