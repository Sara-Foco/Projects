package easyProjects;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicBankingSystem {
	
//	I declare a double variable for the balance and an arraylist for the transaction history
	private double balance;
	private ArrayList<String> transactions;
	
//	Generate a constructor to initialize balance and transaction historu. I set the initial balance to 0 and a void arraylist for transaction history
	public BasicBankingSystem() {
		balance = 0;
		transactions = new ArrayList<String>();
	}
	
//	Method to deposit money
	public void deposit(double amount) {
//		Use an if condition to allow the deposit only if the amount is a positive number > 0
		if (amount > 0) {
			balance += amount;
			transactions.add("Deposited: " + amount + "€"); // save this operation in transiction history
			System.out.println("Transaction completed. Deposited: " + amount + "€");
		} else {
			System.out.println("Deposit failed!! The amount must be positive and greater then 0!!");
		}
	}
	
//	Method to withdraw money
	public void withdraw(double amount) {
//		As the deposit method, I use an if condition to check if the amount is positive. User can withdraw money only if the amount is positive, greater then 0 and it's equals or less then the balance
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			transactions.add("Withdrew: " + amount + "€"); // save this operation in transiction history
			System.out.println("Transaction completed. Withdrew: " + amount + "€");
		} else {
			if (amount <= 0) {
				System.out.println("Deposit failed!! The amount must be positive and greater then 0!!");
			} else {
				System.out.println("Deposit failed!! Insufficient funds!!");
			}
		}
	}
	
//	Method to check and print the balance
	public void checkBalance() {
		System.out.println("Your current balance is: " + balance + "€");
	}
	
//	Method to print transaction history
	public void printTransactions() {
		System.out.println("Your transactions history:");
//		I use a foreach loop to print all the transactions in the arraylist of transaction history
		for (String transaction : transactions) {
			System.out.println(transaction);
		}
	}
	
	public static void main(String[] args) {
		
//		Generate a scanner for user input
		Scanner scan = new Scanner(System.in);
//		Generate a new object BasikBankingSystem named bank using the constructor
		BasicBankingSystem bank = new BasicBankingSystem();
//		Initialize a boolean variable named flag to exit or continue the banking system
		boolean flag = true;
		
		do {
			
			System.out.println("==== BANK MENU ====");
			System.out.println("1) Deposit");
			System.out.println("2) Withdraw");
			System.out.println("3) Check balance");
			System.out.println("4) View transaction history");
			System.out.println("0) Exit");
			
//			Using try and catch to check the input
			try {
				
				System.out.println("Choose the operation:");
				int choise = scan.nextInt();
				
//				Using switch to choose the operation in the menu
				switch (choise) {
				case 1:
//					If user enter 1 he choose deposit
					System.out.println("Enter the deposit amount:");
					double depositAmount = scan.nextDouble();
					bank.deposit(depositAmount);
					break;
					
				case 2:
//					If user enter 2 he choose withdraw
					System.out.println("Enter the withdraw amount:");
					double withdrawAmount = scan.nextDouble();
					bank.withdraw(withdrawAmount);
					break;	
					
				case 3:
//					If user enter 3 he choose to check the balance
					bank.checkBalance();
					break;
					
				case 4:
//					If user enter 4 he choose to see the transaction history
					bank.printTransactions();
					break;
					
				case 0:
//					If user enter 0 he choose to quit
					System.out.println("Goodbye!!");
					flag = false;
					break;

				default:
					System.out.println("You must insert a valid number!!");
					break;
					
				}
				
			} catch (InputMismatchException e) {
				System.out.println("You must insert only the number of the operation!!");
				scan.next();
			}
			
		} while (flag); // continue the banking system as long as flag is true
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}
	

}
