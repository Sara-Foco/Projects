package easyProjects;

import java.util.Scanner;

public class PalindromeChecker {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // i put a flag boolean to continue palindrome checker until it is true, when insert '0' it quit the check
		
		do {
			
			System.out.println("Type a word or a phrase or type '0' to quit:");
			String string = scan.nextLine(); // save user input in a string called string
			
			if (string.equals("0")) {
				System.out.println("Goodbye!!");
				flag = false; 
				break; // if the user insert '0' it quit palindrome checker
			}
			
			String reverse = ""; // i will put the reverse word or phrase here to check if it is palindrome comparing it with the original word or phrase
			
			for (int i = string.length()-1; i >= 0; i--) {
				char c = string.toLowerCase().charAt(i);
				reverse += c; // I save the character from the last one to the first in the reverse string in lower case to check if it is really equals
			}
			
			if (string.toLowerCase().replaceAll(" ", "").equals(reverse.replaceAll(" ", ""))) { // here I compare the original string with the reverse one. With toLowerCase() I modify the string to lower case so I don't have the problem with the upper case characters, with trim() I delete the white spaces at the beginning and the end of the string, with replaceAll() I delete all the white spaces, with equals I check if the original string is equals to the reverse string
				System.out.println(string + " is palindrome!!"); // if strings are equals the original string is palindrome
			} else {
				System.out.println(string + " is NOT palindrome"); // if strings are NOT equals the original string is NOT palindrome
			}
			
		} while (flag); // repeat the palindrome checker while flag is true
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

}
