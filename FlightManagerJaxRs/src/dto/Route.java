/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import resources.Flight;


/**
 *
 * @author norde_000
 */
public class Route {
    private String departureCity;
    private String destinationCity;
    private LocalTime departureTime;
    private LocalTime destinationTime;
    private Duration routeTime;
    private ArrayList<Flight> flights; 
    public Route(ArrayList<Flight> flights){
        this.flights = flights;
        this.departureCity = flights.get(0).getDepartureCity();
        this.destinationCity = flights.get(flights.size()-1).getDestinationCity();
   //     this.departureTime = flights.get(0).getDepartureTime();
  //      this.destinationTime = flights.get(flights.size()-1).getEstimatedArrival();
        this.routeTime = Duration.between(departureTime,destinationTime);
    }

    /**
     * @return the departureCity
     */
    public String getDepartureCity() {
        return departureCity;
    }

    /**
     * @return the destinationCity
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * @return the departureTime
     */
    public LocalTime getDepartureTime() {
        return departureTime;
    }

    /**
     * @return the destinationTime
     */
    public LocalTime getDestinationTime() {
        return destinationTime;
    }

    /**
     * @return the routeTime
     */
    public Duration getRouteTime() {
        return routeTime;
    }

    /**
     * @return the flights
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }
    
}
