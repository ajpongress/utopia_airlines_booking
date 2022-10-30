package Flights_pckg;

public class Flight_DetailsDTO {

    private String flightNumber;
    private String departCityId;
    private String arriveCityId;

    public Flight_DetailsDTO(String _flightNumber, String _departCItyId, String _arriveCityId) {

        setFlightNumber(_flightNumber);
        setDepartCityId(_arriveCityId);
        setArriveCityId(_arriveCityId);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartCityId() {
        return departCityId;
    }

    public void setDepartCityId(String departCityId) {
        this.departCityId = departCityId;
    }

    public String getArriveCityId() {
        return arriveCityId;
    }

    public void setArriveCityId(String arriveCityId) {
        this.arriveCityId = arriveCityId;
    }
}
