/*
	Author:  Chad Lister
	Date:  06/11/2020
	
	This program uses the SupperAccount class and it's two subclasses SavingsAccount and CheckingAcount to create three objects and invoke their toString methods.
*/

import java.util.Scanner;

class TestSupperAccount {
	
	//  Main.
	public static void main(String[] args) {
		
		//  Scanner Object.
		Scanner input = new Scanner(System.in);
		
		//  Variables.
		int accountId;
		double balance;
		double interestRate;
		double overDraft;
		double depositAmount;
		double withdrawAmount;
		
		
		//  Prompt for input, Create SupperAccount and display.
		System.out.printf("\nPlease enter this accounts ID # :  ");
		accountId = input.nextInt();
		System.out.print("Please enter the account balance:  ");
		balance = input.nextDouble();
		System.out.print("Does this account have an interest rate?  Please enter an interest rate or 0 for no:  ");
		interestRate = input.nextDouble();
		SupperAccount account = new SupperAccount(accountId, balance, interestRate);
		System.out.println();
		System.out.println(account.toString());
		
		//  Prompt for input, Create Savings Account and display.
		System.out.printf("\nPlease enter this accounts ID # :  ");
		accountId = input.nextInt();
		System.out.print("Please enter the account balance:  ");
		balance = input.nextDouble();
		System.out.print("Does this account have an interest rate?  Please enter an interest rate or 0 for no:  ");
		interestRate = input.nextDouble();
		SavingsAccount savings = new SavingsAccount(accountId, balance, interestRate);
		System.out.println();
		System.out.println(savings.toString());
				
		//  Prompt for input, Create Checking Account and display.
		System.out.printf("\nPlease enter this accounts ID # :  ");
		accountId = input.nextInt();
		System.out.print("Please enter the account balance:  ");
		balance = input.nextDouble();
		System.out.print("Does this account have an interest rate?  Please enter an interest rate or 0 for no:  ");
		interestRate = input.nextDouble();
		System.out.print("What is the Overdraft limit on this account?  ");
		overDraft = input.nextDouble();
		CheckingAccount checking = new CheckingAccount(accountId, balance, interestRate, overDraft);
		System.out.println();
		System.out.println(checking.toString());
		
		//  Deposit checks.
		System.out.printf("\n\t\t  DEPOSIT CHECKS  \n");		
		System.out.println();		
		System.out.print("For Main Account " + account.getId() + " what would you like to deposit?  ");
		depositAmount = input.nextDouble();
		account.deposit(depositAmount);
		
		System.out.println();
		System.out.print("For Savings Account " + savings.getId() + " what would you like to deposit?  ");
		depositAmount = input.nextDouble();
		savings.deposit(depositAmount);
		
		
		System.out.println();
		System.out.print("For Checking Account " + checking.getId() + " what would you like to deposit?  ");
		depositAmount = input.nextDouble();
		checking.deposit(depositAmount);
		
		
		//  Withdraw checks.
		System.out.printf("\n\t\t  WITHDRAW CHECKS  \n");
		System.out.println();
		System.out.print("For Main Account " + account.getId() + " what would you like to withdraw?  ");
		withdrawAmount = input.nextDouble();
		account.withdraw(withdrawAmount);
		
		System.out.println();
		System.out.print("For Savings Account " + savings.getId() + " what would you like to withdraw?  ");
		withdrawAmount = input.nextDouble();
		savings.withdraw(withdrawAmount);
		
		System.out.println();
		System.out.print("For Checking Account " + checking.getId() + " what is the amount of the check?  ");
		withdrawAmount = input.nextDouble();
		checking.withdraw(withdrawAmount);
	}
}