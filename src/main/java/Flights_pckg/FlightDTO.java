package Flights_pckg;

import java.math.BigDecimal;

public class FlightDTO {

    private String departTime;
    private int seatsAvailable;
    private double price;
    private String arrivalTime;
    private String flightNumber;

    public FlightDTO (String _departTime, int _seatsAvailable, double _price, String _arrivalTime, String _flightNumber) {

        setDepartTime(_departTime);
        setSeatsAvailable(_seatsAvailable);
        setPrice(_price);
        setArrivalTime(_arrivalTime);
        setFlightNumber(_flightNumber);
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
