package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class JetsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApplication startUp = new JetsApplication();
		startUp.run();
	}
	public void run() {
		printMenu(); 
		Scanner keyboard = new Scanner(System.in);
		boolean check = false;
		while (!check) {
			check = switchMenu(takeInput(keyboard));
		}
		keyboard.close();
	}
	public void printMenu() {
		System.out.println(""
				+ "1. List fleet\n"
				+ "2. Fly all jets\n"
				+ "3. View fastest jet\n"
				+ "4. View jet with longest range\n"
				+ "5. Load all Cargo Jets\n"
				+ "6. Dogfight!\n"
				+ "7. Add a jet to Fleet\n"
				+ "8. Remove a jet from Fleet\n"
				+ "9. Quit");
	}
	public int takeInput(Scanner input) {
		int returnLine = input.nextInt();
		return returnLine;
	}
	
	public boolean switchMenu(int numberChoice) { // we might need to pass in the Jet object
		boolean setFlag = false;
		switch (numberChoice) {
		case 1: 
			// list the fleet here
			System.out.println("This is a test to make sure we're looping.");
			break;
		
		case 2:
			System.out.println("This is a test to make sure we're looping.");
			break;
		
			// call fly for all jets 
		case 3:
			System.out.println("This is a test to make sure we're looping.");
			break;
			// find out which jet is the fastest Jet fastestJet()
		case 4:
			System.out.println("This is a test to make sure we're looping.");
			break;
			// find out which jet has the longest range Jet longestRange()
		case 5:
			System.out.println("This is a test to make sure we're looping.");
			break;
			// load all cargo jets loadCargo();
		case 6: 
			System.out.println("This is a test to make sure we're looping.");
			break;
			// Fighter jets go do something 
			
		case 7:
			System.out.println("This is a test to make sure we're looping.");
			break;
			// Add a jet to the Hangar ArrayList call to Hangar.add()
		case 8:
			System.out.println("This is a test to make sure we're looping.");
			break;
			// Delete a jet, using Hangar.remove();
		case 9:
			System.out.println("Exiting from the program, thanks for stopping by.");
			setFlag = true;
			break;
		default:
			System.out.println("Whoa there, you mistyped. Try again.");
		}
		return setFlag;
		
	}
	

}
