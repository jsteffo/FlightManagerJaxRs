/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import resources.Flight;


/**
 *
 * @author norde_000
 */

@XmlRootElement
public class Route {
    private String departureCity;
    private String destinationCity;
    private LocalTime departureTime;
    private LocalTime destinationTime;
    private Duration routeTime;
    private ArrayList<Flight> flights; 

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
