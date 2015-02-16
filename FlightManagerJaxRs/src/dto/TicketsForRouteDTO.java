package dto;

public class TicketsForRouteDTO {

	private int price;
	private String destination;
	private String departure;
	private int availableTickets;




	public TicketsForRouteDTO(int price, int availableTickets) {

		this.price = price;
		this.availableTickets = availableTickets;
	}
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
