/*
	Author:  Chad Lister
	Date:  06/11/2020
	
	This program creates the SavingsAccount subclass of SupperAccount.
*/

public class SavingsAccount extends SupperAccount {
	
	
	//  Constructors.
//	public SavingsAccount() {
//	}
	
	public SavingsAccount(int savingsId, double savingsBalance, double accountAnnualInterestRate) {
		super(savingsId, savingsBalance, accountAnnualInterestRate);
//		id = savingsId;
//		balance = savingsBalance;
//		annualInterestRate = accountAnnualInterestRate;
		this.dateCreated = new java.util.Date();
	}
	
	//  Methods
	public double withdraw(double withdrawAmount) {
		if (withdrawAmount > this.balance) {
			System.out.println("\tInvalid withdraw amount; greater than balance.\n");
		}
		else {
			this.balance = this.balance - withdrawAmount;
			System.out.println("After a withdraw of $ " + withdrawAmount + " the Savings Account's balance would be $ " + this.balance);
		}
		return this.balance;
	}
	
	public double deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
		System.out.println("After a deposit of $ " + depositAmount + " the Savings Account's balance would be $ " + this.balance);
		return this.balance;
	}	
	
	public String toString() {
		return "A savings account id # " + this.id + " was created on " + this.dateCreated + " with a balance of $ " + this.balance + " and an annual interest rate of " + this.annualInterestRate;
	}
}