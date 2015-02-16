package resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.activation.MimeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dto.FlightPathDTO;


@Path("flight")
public class FlightManager {

	private List <City> cityList = new ArrayList<City>();
	
	public FlightManager() {
	initiateCityFlights();	
	}
	
	private void initiateCityFlights(){
		LinkedList <Flight> flightList = new LinkedList<Flight>();
		flightList.add(new Flight("Stockholm", "Göteborg", LocalDate.of(2015, 3, 1), 55, 4, 1));
		flightList.add(new Flight("Stockholm", "Malmö", LocalDate.of(2015, 2, 1), 55, 4, 2));
		flightList.add(new Flight("Stockholm", "Abisko", LocalDate.of(2015, 5, 1), 55, 4, 3));
		cityList.add(new City("Stockholm", flightList));

		flightList = new LinkedList<Flight>();
		flightList.add(new Flight("Göteborg", "Halmstad", LocalDate.of(2015, 1, 1), 55, 4, 4));
		flightList.add(new Flight("Göteborg", "Visby", LocalDate.of(2015, 4, 1), 55, 4, 5));
		cityList.add(new City("Göteborg", flightList));

		flightList = new LinkedList<Flight>();
		flightList.add(new Flight("Malmö", "Halmstad", LocalDate.of(2015, 1, 1), 55, 4, 6));
		flightList.add(new Flight("Malmö", "Stockholm", LocalDate.of(2015, 1, 1), 55, 4, 7));
		cityList.add(new City("Malmö", flightList));

		flightList = new LinkedList<Flight>();
		cityList.add(new City("Abisko", flightList));
		flightList = new LinkedList<Flight>();
		cityList.add(new City("Visby", flightList));
		flightList = new LinkedList<Flight>();
		cityList.add(new City("Halmstad", flightList));
	}
	
	@GET

	@Path("{from}/{to}")
	public List<FlightPathDTO> getPossibleRouting(
			
			@PathParam("from") String departureCity, 
			@PathParam("to") String arrivalCity){
		List <FlightPathDTO> returnList = new ArrayList<FlightPathDTO>();
		List <Flight> currentFlightList = getPossibleRoutingLocal(departureCity, arrivalCity, LocalDate.MIN);
		for(Flight f : currentFlightList) {
			FlightPathDTO dto = new FlightPathDTO();
			dto.setDeparture(f.getDepartureCity());
			dto.setDestination(f.getDestinationCity());
			returnList.add(dto);
		}
		return returnList;
	}
	
	private List<Flight> getPossibleRoutingLocal(String departureCity, String destinationCity, LocalDate date){
		int [] previousArray = new int [1000];
		Comparator<Flight> comp = new Comparator<Flight>() {
			@Override
			public int compare(Flight f1, Flight f2) {
				return f1.getDepartureTime().compareTo(f2.getDepartureTime());
			}
		};
		Set<String> citySet = new HashSet<String>(); //Use this set to keep track of nodes NOT visisted.
		LinkedList <Flight> queue = new LinkedList<Flight>();
		for(City c : cityList){
			citySet.add(c.getName());
			if(c.getName().equalsIgnoreCase(departureCity)){
				for(Flight flight : c.getFlightList()){
					if(flight.getDepartureTime().compareTo(date) >= 0){
						queue.add(flight);	
					}		
				}
			}
		}

		if(queue.isEmpty()) {

			return null;
		}
		while(!citySet.isEmpty()  && !queue.isEmpty()){

			//sort här så vi köra på tid!
			queue.sort(comp); //ej så effektivt
			Flight oldFlight = queue.poll();
			citySet.remove(oldFlight.getDepartureCity());

			City currentCity = null;

			for(City c : cityList){
				if(c.getName().equalsIgnoreCase(oldFlight.getDestinationCity())){
					currentCity = c;
				}
			}
			if(currentCity.getName().equalsIgnoreCase(destinationCity)){
				//We are done
				List<Flight> localFlightList = new ArrayList<Flight>();
				int id = oldFlight.getId();
				while(id != 0){				
					for(City c : cityList){				
						for(Flight f : c.getFlightList()){				
							if(f.getId() == id){
								localFlightList.add(f);	
								id = previousArray[id];
							}
						}
					}
				}
				return localFlightList;
			}
			//For every flight in city
			for(Flight newFlight : currentCity.getFlightList()){
				//Only queue up flight assuming flight TO city occur before flight FROM city
				//Flights are assumed to be instantanious. And we don't want to travel back. Cyclic might still be 
				//a problem

				if(!newFlight.getDestinationCity().equalsIgnoreCase(oldFlight.getDepartureCity()) 
						&& oldFlight.getDepartureTime().compareTo(newFlight.getDepartureTime()) <= 0){
					//If city not already visisted

					if(citySet.contains(newFlight.getDestinationCity())){
						previousArray[newFlight.getId()] = oldFlight.getId();

						queue.add(newFlight);	
					}

				}
			}


		}

		return null;
	}
	
}
