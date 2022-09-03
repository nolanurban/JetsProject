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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApplication startUp = new JetsApplication();
		startUp.run();
	}
	public void run() {
		Scanner keyboard = new Scanner(System.in);
		boolean check = false;

		while (!check) {
			printMenu(); 
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
			for (Jet jet:ourHangar.getHangar()) {
				if (jetWithFastestSpeed.getSpeed() < jet.getSpeed()) {
					jetWithFastestSpeed = jet;
				}
			}
			System.out.print("The jet with the fastest speed in the hangar is the " + jetWithFastestSpeed.getModel());
			System.out.println(" with a maximum speed of " + jetWithFastestSpeed.getSpeed() + " miles per hour.");	
			break;
		case 4:
			Jet jetWithLongestRange = ourHangar.getHangar().get(0);
			for (Jet jet:ourHangar.getHangar()) {
				if (jetWithLongestRange.getRange() < jet.getRange()) {
					jetWithLongestRange = jet;
				}
			}
			System.out.print("The jet with the longest range in the hangar is the " + jetWithLongestRange.getModel());
			System.out.println(" with a maximum range of " + jetWithLongestRange.getRange() + " miles.");
			break;
		case 5:
			for (Jet jet: ourHangar.getHangar()) {
				if (jet.getType().equals("Cargo")) { 
					System.out.println(jet);
					((CargoJet) jet).loadCargo();
				}
			}
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