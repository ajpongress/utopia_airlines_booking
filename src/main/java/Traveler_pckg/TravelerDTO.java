package Traveler_pckg;

public class TravelerDTO {

    // Locals
    private String name;
    private String address;
    private String phone;
    private String email;
    private String dob;

    // Constructor
    public TravelerDTO(String _name, String _address, String _phone, String _email, String _dob) {

        setName(_name);
        setAddress(_address);
        setPhone(_phone);
        setEmail(_email);
        setDob(_dob);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
