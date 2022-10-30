package Employees_pckg;

public class EmployeeDTO {

    private int roleId;
    private String given_name;
    private String family_name;
    private String username;
    private String email;
    private String password;
    private String phone;

    public EmployeeDTO(int _roleId, String _given_name, String _family_name, String _username, String _email, String _password, String _phone ) {

        setRoleId(_roleId);
        setGiven_name(_given_name);
        setFamily_name(_family_name);
        setUsername(_username);
        setEmail(_email);
        setPassword(_password);
        setPhone(_phone);
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
