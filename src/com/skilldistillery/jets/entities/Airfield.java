package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// will have 3-4 additional methods
import java.util.Set;

public class Airfield {
	
//	public Airfield(List<Jet> hangar) {
//		super();
//		Hangar = hangar;
//	}
	public Airfield() {
		
	}
	private List<Jet> Hangar = fillHangar();
	
	public List<Jet> getHangar() {
		return Hangar;
	}

	public void setHangar(List<Jet> hangar) {
		Hangar = hangar;
	}

	public List<Jet> fillHangar() {
	    BufferedReader reader = null;
	    List<Jet> newJetList = new ArrayList<>();
	    
	    try {
	      reader = new BufferedReader(new FileReader("jets.txt"));
	      String line;
	      while((line = reader.readLine()) != null) {
		    String[] container = line.split(",");
		// conditional based on container[0] 
		    if (container[0].equals("Fighter"))
		    	newJetList.add(new CargoJet(container[0],container[1], // model
		    			Double.parseDouble(container[2]), // speed
		    			Integer.parseInt(container[3]), // range
		    			Long.parseLong(container[4]))); // price
		    if (container[0].equals("Cargo"))
		    	newJetList.add(new CargoJet(container[0],container[1], // model
		    			Double.parseDouble(container[2]), // speed
		    			Integer.parseInt(container[3]), // range
		    			Long.parseLong(container[4]))); // price
		    if (container[0].equals("Passenger"))
		    	newJetList.add(new PassengerJet(container[0],container[1], // model
		    			Double.parseDouble(container[2]), // speed
		    			Integer.parseInt(container[3]), // range
		    			Long.parseLong(container[4])));	// price  
	      }
	    }
	    catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    finally {
	      if(reader != null) {
	        try {
	          reader.close();
	        }
	        catch (IOException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	return newJetList;
	  }

	
}
