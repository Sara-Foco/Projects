package easyProjects;

import java.util.Scanner;

// create a class Student with the blueprint of every student
public class Student {
	
//	declare student attributes
	String name; // a string for the name
	String surname; // a string for the surname
	double[] grades; // an array for the grades
	int numSubjects; // an integer for the subjects number
	String[] subjects; // an array for subjects
	
	
//	Generate a constructor to initialize the student object
	public Student(String name, String surname, int numSubjects) {
		this.name = name;
		this.surname = surname;
		this.numSubjects = numSubjects;
		grades = new double[numSubjects]; // array to store grades, one for each subject
		subjects = new String[numSubjects]; // array to store the name of each subject
	}
	
//	method to input subjects
	public void inputSubjects(Scanner scan) {
		scan.nextLine();
//		Using a for loop to insert the name of each subject
		for (int i = 0; i < numSubjects; i++) {
			System.out.println("Enter the name of subject number " + (i+1) + ":");
			subjects[i] = scan.nextLine();
		}
	}
	
//	Method to print subjects
	public void printSubjects() {
		System.out.println("Subjects:");
		for (String subject : subjects) {
			System.out.println("- " + subject);
		}
	}
	
//	Method to input grades
	public void inputGrades(Scanner scan) {
//		Using a for loop to insert one grade for each subject
		for (int i = 0; i < numSubjects; i++) {
			System.out.println("Enter grade for " + subjects[i] + "(0-100):");
			grades[i] = scan.nextDouble();
		}
	}
	
//	Method to calculate average
	public double calculateAverage() {
//		Initialize the total to 0 so then I can sum every grade
		double total = 0;
		for (double grade : grades) {
			total += grade;
		}
		return total / numSubjects;
	}
	
//	Method to return if the student passes or failes
	public String status(double average) {
		return average >= 60 ? "Pass!!" : "Fail";
	}
	
//	Method to display the result
	public void displayResult() {
		double average = calculateAverage();
		String status = status(average);
		System.out.println("Student: " + name + " " + surname);
		System.out.println("Average grade: " + average);
		System.out.println("Status: " + status);
	}
	
}
