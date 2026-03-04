package easyProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialCalculator {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // I put a flag boolean to continue the factorial calculator until it is true, when insert a negative number it will quit the check
		
		do {
			
			try {
				
				System.out.println("Insert a positive integer number or insert a negative number to quit:");
				int num = scan.nextInt(); // save user input in an integer variable named num
				
				if (num < 0) {
					System.out.println("Goodbye");
					flag = false;
					break; // if user insert a negative number he quits factorial calculator
				}
				
				int factorial = 1; // I set the result at 1 so I can save the result of multiplication
				
//				Calculate the factorial (multiplication of all numbers from 1 to user input)
				for (int i = 1; i <= num; i++) {
					factorial *= i;
				}
				
				System.out.println("The factorial of " + num + " is " + factorial); // print the result
				
			} catch (InputMismatchException e) {
				System.out.println("You must insert an INTEGER NUMBER!!!");
				scan.next();
//				I handle the case user input is not an integer number by print an error and clean the scanner so the program don't crush 
			}
			
		} while (flag); // do the factorial calculator as long as the flag is true 
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

}
