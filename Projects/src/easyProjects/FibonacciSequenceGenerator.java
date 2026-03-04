package easyProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciSequenceGenerator {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // I put a flag boolean to continue the Fibonacci sequence generator until it is true, when insert '0' it quit the check
		
		do {
			
			try {
				
				System.out.println("Insert the number of terms or type '0' to quit:");
				int n = scan.nextInt(); // save user input in an integer variable named n
				
				if (n == 0) {
					System.out.println("Goodbye!!");
					flag = false;
					break; // if user inserts '0' he quit the Fibonacci sequence generator
				}
				
//				Each number of Fibonacci sequence is the sum of the two preceding ones, except for the first two
				
//				Initialize the first two Fibonacci numbers
				int num1 = 0, num2 = 1;
				
//				Display the first N Fibonacci numbers
				System.out.print("Fibonaccy sequence: " + num1);
				
//				if n > 1 print also the second number
				if (n > 1) {
					System.out.print(", " + num2);
				}
				
//				Generate Fibonacci sequence using a for loop
				for (int i = 3; i <= n; i++) { // start from the third number to the numbers of terms
					int nextNum = num1 + num2; // the next numbers is the sum of the two preceding once
//					print the next number in the sequence
					System.out.print(", " + nextNum);
//					change the two preceding numbers with the new preceding until it reaches the numbers of terms
					num1 = num2;
					num2 = nextNum;
				}
				System.out.print(";"); // at the end put ";"
				
				System.out.println(); // insert a space between the fibonacci sequence and the next insert of numbers of terms
				
			} catch (InputMismatchException e) {
				System.out.println("You MUST type an INTEGER NUMBER!!");
				scan.next();
//				I handle the case user input is not an integer number by print an error and clean the scanner so the program don't crush 
			}
			
		} while (flag); // do the Fibonacci sequence generator as long as the flag is true 
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

}
