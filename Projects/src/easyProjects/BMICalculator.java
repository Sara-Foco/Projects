package easyProjects;

import java.util.Scanner;

public class BMICalculator {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // I put a flag boolean to continue BMI calculator until it is true, when insert '0' it quit the check
		
		do {
			
			System.out.println("Type your weight (kg) or type '0' to quit:");
			double weight = scan.nextDouble(); // I save user weight in a double named weight
			
			if (weight == 0.0) {
				System.out.println("Goodbye!!");
				flag = false;
				break; // if user insert '0' it will quit BMI calculator
			}
			
			System.out.println("Type your height (m):");
			double height = scan.nextDouble(); // I save user height in a double named height
			
			double bmi = weight / Math.pow(height, 2); // calculate BMI, Math.pow() square the height 
			
//			check BMI with the BMI categories for adults
			if (bmi < 18.5) {
				System.out.println("You're underweight");
			} else if (bmi >= 18.5 && bmi <= 24.9) {
				System.out.println("Congratulation!! You have a healthy weight!!");
			} else if (bmi >= 25 && bmi <= 29.9) {
				System.out.println("You're overweight");
			} else {
				System.out.println("You're obese");
			}
			
		} while (flag); // do BMI calculator as long as the flag is true 
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

}
