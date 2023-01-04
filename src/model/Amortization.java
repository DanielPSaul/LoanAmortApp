package model;

import java.text.NumberFormat;

public class Amortization {
	
	private Loan loan;

	/**
	 * @param loan
	 * A default constructor that will create an amortization object with a basic, empty loan instance. 
	 */
	public Amortization() {
		this.loan = new Loan();
	}
	
	/**
	 * @param loan
	 * An overloaded constructor that will create an instance using the loan that is passed to it
	 */
	public Amortization(Loan loan) {
		this.loan = loan;
	}

	/**
	 * @return the loan
	 */
	public Loan getLoan() {
		return loan;
	}

	/**
	 * @param loan the loan to set
	 */
	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Amortization [loan=" + loan + "]";
	}
	
	public String doAmortization(){
		// Initialize useful local variables 
		String htmlTable = "<table border=1>";  // used to hold resulting html Table
		NumberFormat cf = NumberFormat.getCurrencyInstance(); // used to format the currency numbers
		cf.setMaximumFractionDigits(2); 
		
		double balance = this.loan.getPrincipal();  // initializes balance to the principal
		
		// add header row
		htmlTable += "<tr>";
		htmlTable += "<td>";
		htmlTable += "Month";
		htmlTable += "</td>";
		htmlTable += "<td>";
		htmlTable += "Monthly Payment";
		htmlTable += "</td>";
		htmlTable += "<td>";
		htmlTable += "Monthly Interest Payment";
		htmlTable += "</td>";
		htmlTable += "<td>";
		htmlTable += "Monthly Principal Payment";
		htmlTable += "</td>";
		htmlTable += "<td>";
		htmlTable += "Monthly Balance";
		htmlTable += "</td>";
		htmlTable += "</tr>";
		
		// add the rest of the rows
		for (int month = 1; month <= this.loan.getMonths(); month++){
		  
			// calculate values for this row
			double monthlyInterestPayment = balance * this.loan.getMonthlyRate();
			double monthlyPrincipalPayment = this.loan.getMonthlyPayment() - monthlyInterestPayment;
			balance = balance - monthlyPrincipalPayment;
			
			// add row values
			htmlTable += "<tr>";
			htmlTable += "<td>";
			htmlTable += month;
			htmlTable += "</td>";
			htmlTable += "<td>";
			htmlTable += cf.format(this.loan.getMonthlyPayment());
			htmlTable += "</td>";
			htmlTable += "<td>";
			htmlTable += cf.format(monthlyInterestPayment);
			htmlTable += "</td>";
			htmlTable += "<td>";
			htmlTable += cf.format(monthlyPrincipalPayment);
			htmlTable += "</td>";
			htmlTable += "<td>";
			htmlTable += cf.format(balance);
			htmlTable += "</td>";
			htmlTable += "</tr>";
			
		}
		
		htmlTable += "";
		htmlTable += "</table>";
		return htmlTable;
	}

}
