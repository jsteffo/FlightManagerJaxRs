package resources;

import java.util.LinkedList;
import java.util.List;

public class City {

	LinkedList<Flight> flightList;
	String name;
	
	public City(String name, LinkedList<Flight> flightList){
		this.flightList = flightList;
		this.name = name;
		
	}
	
	public LinkedList<Flight> getFlightList() {
		return flightList;
	}
	public String getName() {
		return name;
	}
}
