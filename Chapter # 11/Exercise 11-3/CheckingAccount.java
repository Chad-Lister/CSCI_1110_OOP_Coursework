/*
	Author:  Chad Lister
	Date:  06/11/2020
	
	This program creates the CheckingAccount subclass of SupperAccount.
*/

class CheckingAccount extends SupperAccount {
	
	//  Attributes
	double overDraftLimit;
	
	//  Constructors
	
	public CheckingAccount(int checkingId, double checkingBalance, double accountAnnualInterestRate, double overDraftLimit) {
		super(checkingId, checkingBalance, accountAnnualInterestRate);
//		setId(checkingId);
//		setBalance(checkingBalance);
//		setAnnualInterestRate(accountAnnualInterestRate);
		this.overDraftLimit = overDraftLimit;
		this.dateCreated = new java.util.Date();
	}
	
	//  Methods
	public double withdraw(double withdrawAmount) {
		
		if (withdrawAmount > (this.balance + this.overDraftLimit )){
			System.out.printf("\tInvalid withdraw.  Excedes balance and overdraft limit.\n");
		}
		else {
			this.balance = this.balance - withdrawAmount;
			System.out.println("After a withdraw of $ " + withdrawAmount + " the Checking Account's balance would be $ " + this.balance);
		}
		return this.balance;
	}
	
	public double deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
		System.out.println("After a deposit of $ " + depositAmount + " the Checking Account's balance would be $ " + this.balance);
		return this.balance;
	}	
	
//	public double getOverDraftLimit() {
//		return overDraftLimit;
//	}
	
	public String toString() {
		return "A checking account id # " + this.id + " was created on " + this.dateCreated + " with a balance of $ " + this.balance + " with an overdraft limit of $ " + this.overDraftLimit + " and an annual interest rate of " + this.annualInterestRate;
	}
}