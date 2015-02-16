/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author norde_000
 */
public class TicketAndPrice {
    private int numberOfTickets;
    private int priceOfTicket;
    public TicketAndPrice(int numberOfTickets,int priceOfTicket){
        this.numberOfTickets = numberOfTickets;
        this.priceOfTicket = priceOfTicket;
    }

    /**
     * @return the numberOfTickets
     */
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    /**
     * @return the priceOfTicket
     */
    public int getPriceOfTicket() {
        return priceOfTicket;
    }

    /**
     * @param numberOfTickets the numberOfTickets to set
     */
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    /**
     * @param priceOfTicket the priceOfTicket to set
     */
    public void setPriceOfTicket(int priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }
}
