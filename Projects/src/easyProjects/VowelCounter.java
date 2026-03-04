package easyProjects;

import java.util.Scanner;

public class VowelCounter {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // use the scanner to take user input
		
		boolean flag = true; // I put a flag boolean to continue the vowel counter until it is true, when insert '0' it quit the check
		
		do {
			
			System.out.println("Type a string or type '0' to quit:");
			String string = scan.nextLine(); // save the user input in a string variable named string
			
//			if user type 0 quit the vowel counter
			if (string.equals("0")) {
				System.out.println("Goodbye!!");
				flag = false;
				break;
			}
			
//			Initialize the vowel count to so then i can increment it every time that I found a vowel
			int count = 0;
			
//			I use a for loop to search vowels
			for (int i = 0; i < string.length(); i++) {
//				Create a char variable for the characters, I use lowerCase() to make less comparison
				char c = string.toLowerCase().charAt(i);
//				check if the char is a vowel, if it is a vowel increment count
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					count++;
				}
				
			}
			
//			print the result
			if (count == 0) {
				System.out.println("There isn't vowel in " + string);
			} else if (count == 1) {
				System.out.println("There is 1 vowel in " + string);
			} else {
				System.out.println("There are " + count + " vowels in " + string);
			}
			
		} while (flag); // do the vowel counter as long as the flag is true 
		
		scan.close(); // close the scanner because I don't need it anymore
		
	}

}
