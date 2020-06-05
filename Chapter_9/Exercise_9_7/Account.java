/*
	Author:  Chad Lister
	Date:
	
	This program defines an account class with 5 data fields, a no-arg constructor, another constructor, getters and accessors, and 4 methods (getMonthlyInterestRate, getMonthlyInterest, withrdaw, and deposit).

*/

public class Account {
	
	//  Data Fields.
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private java.util.Date dateCreated;
	
	//  Default Constructor.
	public Account() {
		this(0, 0, 0);
		
	}
	
	//  Constructor with specific fields.
	public Account(int accountId, double accountBalance, double accountAnnualInterestRate) {
		this.id = accountId;
		this.balance = accountBalance;
		this.annualInterestRate = accountAnnualInterestRate;
		dateCreated = new java.util.Date();
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
//		getMonthlyInterestRate();
		double monthlyInterest = balance * getMonthlyInterestRate();
		return monthlyInterest;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public void setId(int accountId) {
		id = accountId;
		return;
	}
	
	public void setBalance(double accountBalance) {
		balance = accountBalance;
		return;
	}
	
	public void setAnnualInterestRate(double accountAnnualInterestRate) {
		annualInterestRate = accountAnnualInterestRate;
		return;
	}
	
	public double withdraw(double withdrawAmount) {
		balance = balance - withdrawAmount;
		return balance;
		}
	
	public double deposit(double depositAmount) {
		balance = balance + depositAmount;
		return balance;
	}
}