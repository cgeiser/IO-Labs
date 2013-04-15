package lab1;

/**
 *
 * @author cgeiser
 */
public class Contact {
    private String firstName, lastName,
            address,
            city, state, zip,
            email,
            phone;

    public Contact() {
        
    }
    
    
    public Contact(String fn, String ln, String ad, String city, String st,
            String zip, String em, String ph) {
        this.setFirstName(fn);
        this.setLastName(ln);
        this.setAddress(ad);
        this.setCity(city);
        this.setState(st);
        this.setZip(zip);
        this.setEmail(em);
        this.setPhone(ph);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + 
                "\n" + address +
                "\n" + city + ", " + state + "  " + zip +
                "\n" + email +
                "\n" + phone + "\n";
    }
    
    
}
