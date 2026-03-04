package easyProjects;

import java.util.HashMap;
import java.util.Scanner;

public class SimpleVotingSystem {
	
//	Hasmap to store candidate names and their vote counts
//	                       name    vote counts
	private static HashMap<String, Integer> votes = new HashMap<String, Integer>();
	
//	Method to initialize candidates, I initialize three candidate names and initialize vote count to 0
	public static void candidates() {
		votes.put("Mickey Mouse", 0);
		votes.put("Son Goku", 0);
		votes.put("Homer Simpson", 0);
	}
	
//	Method to cast a vote
	public static void vote(String candidate) {
//		check if candidate exists
		if (votes.containsKey(candidate)) {
//			if candidate exists increment his vote count by one
			votes.put(candidate, votes.get(candidate) + 1);
			System.out.println("Vote cast correctly for " + candidate);
		} else {
			System.out.println("This candidate does NOT exists. Try again!!");
		}
	}
	
//	Method to display the vote count
	public static void displayResults() {
//		Use foreach to catch every candidates and then their vote counts
		for (String candidate : votes.keySet()) {
			if (votes.get(candidate) == 1) {
				System.out.println(candidate + " has " + votes.get(candidate) + " vote!!");
			} else {
				System.out.println(candidate + " has " + votes.get(candidate) + " votes!!");
			}
		}
	}
	
	public static void main(String[] args) {
//		Create a scanner for user input
		Scanner scan = new Scanner(System.in);
//		Initialize a boolean variable to continue voting as long as it is true
		boolean voting = true;
//		Initialize candidates
		candidates();
		
		while (voting) {
			System.out.println("Enter the candidate name to vote for (Mickey Mouse, Son Goku, Homer Simpson) (ATTENTION!! They are case sensitive!) or type 'exit' to quit:");
			String userVote = scan.nextLine();
			
			if (userVote.equalsIgnoreCase("exit")) {
				voting = false;
			} else {
				vote(userVote); // cast the user vote
			}
		}
		
//		if voting == false, voting has ended so I can print the results
		System.out.println("Voting has ended. Final results:");
		displayResults();
		
		scan.close();
		
	}
	
	

}
