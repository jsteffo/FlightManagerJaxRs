package dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TicketsForRouteDTO {

	private int price;

	private int availableTickets;




	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}
	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}
}
