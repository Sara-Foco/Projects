package easyProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumberChecker {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // I put a flag boolean to continue prime number checker until it is true, when insert '0' it quit the check
		
		do {
			try {
				System.out.println("Type a positive integer number or type '0' to quit:");
				int num = scan.nextInt(); // save user input in an integer variable named num
				
				if (num == 0) {
					System.out.println("0 is not a prime number!"); // I give the result for 0 in case user put '0' to verify if it is a prime number
					System.out.println("Goodbye!!");
					flag = false;
					break; // quit prime number checker
				}
				
	//			check if 'num' is a prime number (it is divisible only for itself and 1, grater then 1)
				if (num < 0) {
					System.out.println(num + " is NOT a prime number"); // I handle the case where the number is less then 0
				} else if (num == 1) {
					System.out.println(num + " is NOT a prime number"); // I handle the case where the number is 1
				} else { // I handle all other cases
					
					boolean prime = true;
					
					for (int i = 2; i < num; i++) {
						if (num % i == 0) {
							prime = false;
							break; // if the number is divisible for any number from 2 to num-1 so it isn't prime
						}
					}
					
	//				Now I can check if num is a prime number
					if (prime) { // if after the for loop prime is still true, it is a prime number
						System.out.println(num + " is a prime number!!");
					} else { // if the for loop finds a divisor of num, it is not a prime number
						System.out.println(num + " is NOT a prime number");
					}
					
				}
				
			} catch (InputMismatchException e) {
				System.out.println("You MUST type an INTEGER NUMBER!!");
				scan.next();
//				I handle the case user input is not an integer number by print an error and clean the scanner so the program don't crush 
			}
			
		} while (flag); // do prime number checker as long as the flag is true 
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

}
