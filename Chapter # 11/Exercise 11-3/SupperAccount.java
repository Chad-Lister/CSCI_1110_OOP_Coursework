/*
	Author:  Chad Lister
	Date:  06/11/2020
	
	(Subclasses of Account) In Programming Exercise 9.7, the Account class was defined to model a bank account. An account has the properties account number, balance, annual interest rate, and date created, and methods to deposit and withdraw funds. Create two subclasses: checking accounts and saving accounts. A checking account has an overdraft limit, but a savings account cannot be overdrawn.
	
	Draw the UML diagram for the classes and then implement them. Write a test program that creates objects of Account, SavingsAccount, and CheckingAccount and invokes their toString() methods.
*/

public class SupperAccount {
	
	//  Data Fields.
	
	int id;
	double balance;
	double annualInterestRate;
	java.util.Date dateCreated;
	
	//  Default Constructor.
	public SupperAccount() {
		this(0, 0, 0);
		
	}
	
	//  Constructor with specific fields.
	public SupperAccount(int accountId, double accountBalance, double accountAnnualInterestRate) {
		this.id = accountId;
		this.balance = accountBalance;
		this.annualInterestRate = accountAnnualInterestRate;
		this.dateCreated = new java.util.Date();
	}
	
	//  Methods
	public int getId() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = (annualInterestRate / 100) / 12;
		return monthlyInterestRate;
	}
	
	public double getMonthlyInterest() {

		double monthlyInterest = balance * getMonthlyInterestRate();
		return monthlyInterest;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public void setId(int accountId) {
		id = accountId;
	}
	
	public void setBalance(double accountBalance) {
		balance = accountBalance;
	}
	
	public void setAnnualInterestRate(double accountAnnualInterestRate) {
		annualInterestRate = accountAnnualInterestRate;
	}
	
	public double withdraw(double withdrawAmount) {
		if (withdrawAmount > this.balance) {
			System.out.printf("\tInvalid withdraw; greater than balance.\n");
		}
		else {
			this.balance = this.balance - withdrawAmount;
			System.out.println("After a withdraw of $ " + withdrawAmount + " the Main Account's balance would be $ " + this.balance);
			System.out.println();
		}
		return this.balance;
		}
	
	public double deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
		System.out.println("After a deposit of $ " + depositAmount + " the Main Account's balance would be $ " + this.balance);
		System.out.println();
		return this.balance;
	}
	
	public String toString() {
		return "An account id # " + this.id + " was created on " + this.dateCreated + " with a balance of $ " + this.balance + " and an annual interest rate of " + this.annualInterestRate;
	}
}