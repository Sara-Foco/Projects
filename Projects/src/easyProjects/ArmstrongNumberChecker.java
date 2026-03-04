package easyProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArmstrongNumberChecker {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // I put a flag boolean to continue the Armstrong number checker until it is true, when insert '0' it quit the check
		
		do {
			
			try {
				
				System.out.println("Type a positive integer number or type '0' to quit:");
				long num = scan.nextLong(); // save user input in a long variable named num
				
//				if num == 0 set flag to false and quit
				if (num == 0) {
					System.out.println("0 is an Armstrong number!!");
					System.out.println("Goodbye!");
					flag = false;
					break;
				}
				
				if (num < 0) {
					System.out.println("The number must be positive!!");
					continue;
				}
				
//				set a variable for the number so it doesn't modify the user number
				long numTemp = num;
				
//				Initialize the number of digits to 0
				int digitsNum = 0;
				
//				use a while loop to calculate the number of digits. It continue the division while the num > 0 so it can count the right numbers of digits
				while (numTemp > 0) {
					numTemp /= 10;
					digitsNum++;
				}
				
//				Initialize the sum to 0 and the digits to the original number
				long sum = 0, tempS = num;
				
//				again a while loop but, this time, to calculate the sum of the number's digits raised to the power of the number of digits
				while (tempS > 0) {
					long digit = tempS % 10; // the digit is the rest of the number divide by 10
					sum += Math.pow(digit, digitsNum);
					tempS /= 10;
				}
				
//				Check if the number is Armstrong
				if (num == sum) {
					System.out.println(num + " is an Armstrong number!!");
				} else {
					System.out.println(num + " is NOT an Armstrong number");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("You MUST type an INTEGER NUMBER!!");
				scan.next();
//				I handle the case user input is not an integer number by print an error and clean the scanner so the program don't crush
			}
			
		} while (flag); // do the Armstrong number checker as long as the flag is true 
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

}
