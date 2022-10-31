package Employees_pckg;

public class EmployeeDTO {

    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int enabled;
    private int locked;
    private int userRole;

    public EmployeeDTO(String _password, String _email, String _firstName, String _lastName, int _enabled, int _locked, int _userRole) {

        setPassword(_password);
        setEmail(_email);
        setFirstName(_firstName);
        setLastName(_lastName);
        setEnabled(_enabled);
        setLocked(_locked);
        setUserRole(_userRole);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
