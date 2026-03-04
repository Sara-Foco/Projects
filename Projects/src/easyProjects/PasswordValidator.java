package easyProjects;

import java.util.Scanner;

public class PasswordValidator {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // I put a flag boolean to continue the password validator until it is true, when insert '0' it quit the check
		
		do {
			
			System.out.println("The password must have at least 6 characters, 1 upper case letter, 1 lower case letter, 1 number and 1 special character");
			System.out.println("Enter your password or type '0' to quit:");
			String psw = scan.nextLine(); // save the user password in a string variable named psw

//			if user type 0 quit the vowel counter
			if (psw.equals("0")) {
				System.out.println("Goodbye!!");
				flag = false;
				break;
			}
			
//			Call the boolean method for the validation
			if (validatePsw(psw)) {
				System.out.println("Valid password");
			} else {
				System.out.println("Invalid password, try again!!");
			}
			
		} while (flag); // do the password validator as long as the flag is true 
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

	private static boolean validatePsw(String psw) {
//		Check the lenght (min 6 characters)
		if (psw.length() < 6) {
			System.out.println("You must insert at least 6 characters!");
			return false;
		}
		
//		Initialize all other checks
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasNumber = false;
		boolean hasSpecialChar = false;
		
//		use a for loop to check each characters
		for (int i = 0; i < psw.length(); i++) {
			char c = psw.charAt(i); // find the character in position i
//			check if c is in upper case
			if (Character.isUpperCase(c)) {
				hasUpperCase = true;
			}
//			check if c is in lower case
			if (Character.isLowerCase(c)) {
				hasLowerCase = true;
			}
//			check in c is a number
			if (Character.isDigit(c)) {
				hasNumber = true;
			}
//			check if c is a special character
			if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
				hasSpecialChar = true;
			}
		}
		
		if (!hasUpperCase) {
			System.out.println("The password must contain at least 1 upper case character!!");
		}
		if (!hasLowerCase) {
			System.out.println("The password must contain at least 1 lower case character!!");
		}
		if (!hasNumber) {
			System.out.println("The password must contain at least 1 number!!");
		}
		if (!hasSpecialChar) {
			System.out.println("The password must contain at least 1 special character!!");
		}
		
//		return if all checks are true
		return hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar;
		
	}

}
