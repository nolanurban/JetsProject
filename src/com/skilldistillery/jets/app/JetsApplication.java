package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApplication {
	Airfield ourHangar = new Airfield();
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApplication startUp = new JetsApplication();
		startUp.run();
		keyboard.close();

	}
	public void run() {
	
		boolean check = false;

		while (!check) {
			printMenu(); 
			check = switchMenu(takeInput(keyboard));		
		}
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
			System.out.println("Model\tSpeed\tRange\tPrice");
			for(Jet jet: ourHangar.getHangar()) {
				System.out.println(
						jet.getModel() + "\t" +
						jet.getSpeed() + "\t" +
						jet.getRange() + "\t" +
						jet.getPrice() + "\t" 
						
						);
			}
			break;  // fix this cosmetic issue later
		
		case 2:
			for(Jet jet: ourHangar.getHangar()) 
				jet.fly();
				break;
		
		case 3:
			Jet jetWithFastestSpeed = ourHangar.getHangar().get(0);
			for (Jet jet: ourHangar.getHangar()) {
				if (jetWithFastestSpeed.getSpeed() < jet.getSpeed()) {
					jetWithFastestSpeed = jet;
				}
			}
			System.out.print("The jet with the fastest speed in the hangar is the " + jetWithFastestSpeed.getModel());
			System.out.println(" with a maximum speed of " + jetWithFastestSpeed.getSpeed() + " miles per hour.");	
			break;
		case 4:
			Jet jetWithLongestRange = ourHangar.getHangar().get(0);
			for (Jet jet: ourHangar.getHangar()) {
				if (jetWithLongestRange.getRange() < jet.getRange()) {
					jetWithLongestRange = jet;
				}
			}
			System.out.print("The jet with the longest range in the hangar is the " + jetWithLongestRange.getModel());
			System.out.println(" with a maximum range of " + jetWithLongestRange.getRange() + " miles.");
			break;
		case 5:
			for (Jet jet: ourHangar.getHangar()) {
				if (jet.getType().equals("Cargo")) { // re-wrote all of Jet class to create a getType to use .equals()
					((CargoJet) jet).loadCargo();
				}
			}
			break;

		case 6: 
			for (Jet jet: ourHangar.getHangar()) {
				if (jet.getType().equals("Fighter")) { 
					((FighterJet) jet).fight();
				}
			}
			break;
			
		case 7:
			
			newJetMenu();
			break;

		case 8:
			removeJetMenu();
			break;

		case 9:
			System.out.println("Exiting from the program, thanks for stopping by.");
			setFlag = true;
			break;
		default:
			System.out.println("Whoa there, you mistyped. Try again.");
		}
		return setFlag;	
	}
	public void removeJetMenu() {
		
		boolean passGo = false;
		int number = 1;
		while(!passGo) {
			for(Jet jet: ourHangar.getHangar()) {
				System.out.println(number + ". " +
						jet.getModel() + "\t" +
						jet.getSpeed() + "\t" +
						jet.getRange() + "\t" +
						jet.getPrice() + "\t" 
						
						);
				number++;
			}
			
			System.out.println("Please enter which plane you would like to remove: ");
			int choice = takeInput(keyboard) - 1;
			if (choice >= 0 && choice <= ourHangar.getHangar().size()) {
				ourHangar.removeJet(choice); // I should probably check if this will be valid
				passGo = true;
			}
			else System.out.println("Invalid selection, try again!");
		}
			System.out.println("Jet removed!");
	
	}
		
	
	
	
	
	public void newJetMenu() {
		String type = ""; 
		boolean passGo = false;
		while(!passGo) {
			

			System.out.println("Please enter the type of jet: \n1. Fighter Jet\n2. CargoJet\n3. PassengerJet\n ");

			int typeInput = takeInput(keyboard);
			
			if (typeInput == 1) {
				type = "Fighter";
				passGo = true;
			}
			else if (typeInput == 2) { 
				type = "Cargo";
				passGo = true;
			}
			else if (typeInput == 3) {
				type = "Passenger";
				passGo = true;
			}
			else { 
				System.out.println("Error, please re-enter the value");
				passGo = false;
			}

		}

		// part 2 of options

		System.out.println("Please enter a model: ");
		String model = keyboard.next();
		System.out.println("Please enter a speed: ");
		double speed = keyboard.nextDouble();
		System.out.println("Please enter a range: ");
		int range = keyboard.nextInt();
		System.out.println("Please enter a cost: ");
		long price = keyboard.nextLong();
		
		if (type.equals("Fighter"))
			ourHangar.pushNewJet(new FighterJet(type, model, speed, range, price));
		
		if (type.equals("Cargo"))
			ourHangar.pushNewJet(new CargoJet(type, model, speed, range, price));
		
		if (type.equals("Passenger"))
			ourHangar.pushNewJet(new PassengerJet(type, model, speed, range, price));
		System.out.println("New Jet added!");
	}
}