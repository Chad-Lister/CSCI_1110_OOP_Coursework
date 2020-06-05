/*
	Author:  Chad Lister
	Date:

	This program creates an Account object with an account ID of 1122, a balance of $20,000, and an annual interest rate of 4.5%. Use the withdraw method to withdraw $2,500, use the deposit method to deposit $3,000, and print the balance, the monthly interest, and the date when this account was created.
*/

class TestAccount {
	//  Main Method
	public static void main(String[] args) {
		
		//  Create the account and set account fields.
		Account newAccount = new Account();
		newAccount.setId(1122);
		newAccount.setBalance(20000);
		newAccount.setAnnualInterestRate(4.5);
		newAccount.getDateCreated();
		
		//  Display to screen.
		System.out.println("Account Created:");
		System.out.printf("\nAccount ID:  " + newAccount.getId() + "\tAccount Balance:  " + "$%10.2f", newAccount.getBalance());
		
		//  Withdraw $2,500.
		newAccount.withdraw(2500);
		
		//  Deposit $3,000.
		newAccount.deposit(3000);
		
		double monthlyInterest = newAccount.getMonthlyInterest();
		
		//  Display end results.
		System.out.println();
		System.out.printf("\nAccount Balance:  " + newAccount.getBalance() + "  Monthly Interest:  " + monthlyInterest + "  Date Created:  " + newAccount.getDateCreated());
		
	}
}