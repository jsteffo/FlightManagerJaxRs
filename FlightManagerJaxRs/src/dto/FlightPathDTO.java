package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightPathDTO {

	private String destination;
	private String departure;



	public String getDestination() {
		return destination;
	}
	public String getDeparture() {
		return departure;
	}


	public void setDestination(String destination){
		this.destination = destination;
	}

	
	public void setDeparture(String departure) {
		this.departure = departure;
	}
}
