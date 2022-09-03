package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
// will have 3-4 additional methods
import java.util.Set;

public class Airfield {
	private List<Jet> Hangar;
	
	private void fillHangar() {
	    BufferedReader reader = null;
	    try {
	      reader = new BufferedReader(new FileReader("jets.txt"));
	      String line;
	      while((line = reader.readLine()) != null) {
	        Hangar.add(line);
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
	  }

	
}
