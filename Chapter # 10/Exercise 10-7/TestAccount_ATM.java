/*
	Author:  Chad Lister
	Date:  06/06/2020

	(Game: ATM machine) Use the Account class created in Programming Exercise 9.7 to simulate an ATM machine. Create ten accounts in an array with id 0, 1,..., 9, and initial balance $100.

	The system prompts the user to enter an id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id is accepted, the main menu is displayed as shown in the sample run. You can enter a choice 1 for viewing the current balance, 2 for withdrawing money, 3 for depositing money, and 4 for exiting the main menu.

	Once you exit, the system will prompt for an id again. Thus, once the system starts, it will not stop.

	***  Output in test run isn't formatted properly.
*/

import java.util.Scanner;

class TestAccount_ATM {
	//  Main Method
	public static void main(String[] args) {
		
		//  Initialize Scanner.
		Scanner input = new Scanner(System.in);
		
		//  Create array of 10 accounts and set balance fields.
		Account_ATM[] accountArray = new Account_ATM[10];
		
		for (int a = 0; a < 10; a++){
			
			accountArray[a] = new Account_ATM(a, 100, 2.5);	
		
		}
		
		//  Display main loop requiring valid account id.
		
		int endlessLoop1 = 0;
		
		do {
			
			System.out.println();
			System.out.print("Enter an account id:  ");
			
			int id = input.nextInt();
			
			//  Check for valid account in array.
			for (int i = 0; i < accountArray.length; i++) {
				
				//  Get account for object.
				int account = accountArray[i].getId();
				
				//  If account matches object's account.
				if (id == account) {
					
					//  Display second endless MainLoop.
					int endlessLoop2 = 0;
					do {
						System.out.println();
						System.out.printf("\t\t *** Main Menu ***\t" + "Account #: " + account);
						System.out.println();
						System.out.printf("\t1:  Check balance\n");
						System.out.printf("\t2:  Withdrawl\n");
						System.out.printf("\t3:  Deposit\n");
						System.out.printf("\t4:  Exit\n");
					
						System.out.println();
						System.out.printf("\tEnter a choice:  ");
						int mainMenu = input.nextInt();
						
						if (mainMenu == 1) {
							
							//  Display account balance.
							System.out.println();
							System.out.printf("\tThe balance is " + accountArray[account].getBalance() + ".\n");
						}
						else if (mainMenu == 2) {
							
							//  Withdraw from account.
							System.out.println();
							System.out.printf("\tEnter an amount to withdraw:  ");
							double withdraw = input.nextDouble();
							accountArray[account].withdraw(withdraw);
						}
						else if (mainMenu == 3) {
							
							//  Deposit to account.
							System.out.println();
							System.out.printf("\tEnter an amount to deposit:  ");
							double deposit = input.nextDouble();
							accountArray[account].deposit(deposit);
						}
						else if (mainMenu == 4) {
							
							//  Exit inner Main menu back to get account id.
							break;
						}
					} while (endlessLoop2 != 1);
				}
			}
		} while (endlessLoop1 != 1);		//  Keeps looping as exercise requires.

	}  //  End Main Method.
}