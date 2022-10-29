package Airport_pckg;

public class AirportDTO {

    // Locals
    private String iataIdent;
    private String city;
    private String name;
    private int airportId;

    // Constructor
    public AirportDTO(String _iataIdent, String _city, String _name, int _airportId) {

        setIataIdent(_iataIdent);
        setCity(_city);
        setName(_name);
        setAirportId(_airportId);
    }

    public String getIataIdent() {
        return iataIdent;
    }

    public void setIataIdent(String iataIdent) {
        this.iataIdent = iataIdent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }
}
