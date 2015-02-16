/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author norde_000
 */
public class Flight {
    private String destinationCity;
    private String departureCity;
    //private long flightLenght;      // Tid flyget tar i minuter
    //private LocalTime departureTime;    // LocalTime finns bara i java 8, ska man köra det eller ngt annat?
    //private LocalTime estimatedArrival;
    private int id;
    private LocalDate departureTime;
    private int price;
    private int numberOfTickets;    // för att se antal tickets bara o getta denna, för o boka så får antagligen en boknings metod i WSen använda set funktionen för att minska med en
    
    public Flight(String departureCity, String destinationCity, LocalDate departureTime, int price, int numberOfTickets, int id){
        this.destinationCity = destinationCity;
        this.departureCity = departureCity;
        this.id = id;
        //this.flightLenght = flightLenght;
        this.departureTime = departureTime;    // gör så vi bara får med HH:MM
        this.price = price;
        //this.estimatedArrival = departureTime.plus(flightLenght,ChronoUnit.MINUTES);    // adderar flightlenght antal minuter till tiden
        this.numberOfTickets = numberOfTickets;
    }

    /**
     * @return the destinationCity
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * @return the departureCity
     */
    public String getDepartureCity() {
        return departureCity;
    }

    /**
     * @return the flightLenght
     */
//    public long getFlightLenght() {
//        return flightLenght;
//    }

    /**
     * @return the departureTime
     */
    public LocalDate getDepartureTime() {
        return departureTime;
    }

    /**
     * @return the estimatedArrival
     */
//    public LocalTime getEstimatedArrival() {
//        return estimatedArrival;
//    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the numberOfTickets
     */
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    
    public int getId(){
    	return id;
    }

    /**
     * @param numberOfTickets the numberOfTickets to set
     */
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
    
    
}
