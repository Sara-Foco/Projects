package easyProjects;

import java.util.Scanner;

public class StudentGradeSystem {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		Initialize a boolean flag to continue student grade system while it's true
		boolean flag = true;
		
//		do-while
		do {
			
//			Input student details or type 0 in the name to quit
			System.out.println("Enter student name or type '0' to quit");
			String name = scan.nextLine();
			
			if (name.equals("0")) {
				System.out.println("Goodbye!!");
				flag = false;
				break;
			}
			
			System.out.println("Enter student surname:");
			String surname = scan.nextLine();
			System.out.println("Enter the number of subjects:");
			int numSubjects = scan.nextInt();
			
//			Create a Student object
			Student student = new Student(name, surname, numSubjects);
			
//			Input subjects names and print them
			student.inputSubjects(scan);
			student.printSubjects();
			
//			Input grades and display result
			student.inputGrades(scan);
			student.displayResult();
			
			scan.nextLine(); // I need this to clean the scanner
			
		} while (flag);
		
		scan.close();
		
	}

}
