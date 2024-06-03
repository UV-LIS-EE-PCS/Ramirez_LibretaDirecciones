package address.data;

/**
 * The AddressEntry class represents an entry in the address book,
 * containing personal details such as name, address, and contact information.
 */
public class AddressEntry {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int ZIP;
    private String phoneNumber;
    private String emailAddress;

    /**
     * Constructs a new AddressEntry with the specified details.
     *
     * @param firstName     the first name of the person
     * @param lastName      the last name of the person
     * @param street        the street address
     * @param city          the city of residence
     * @param state         the state of residence
     * @param ZIP           the ZIP code
     * @param phoneNumber   the phone number
     * @param emailAddress  the email address
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int ZIP, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.ZIP = ZIP;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Gets the street address.
     *
     * @return the street address
     */
    public String getStreet(){
        return street;
    }

    /**
     * Gets the city of residence.
     *
     * @return the city of residence
     */
    public String getCity(){
        return city;
    }

    /**
     * Gets the state of residence.
     *
     * @return the state of residence
     */
    public String getState(){
        return state;
    }

    /**
     * Gets the ZIP code.
     *
     * @return the ZIP code
     */
    public int getZIP(){
        return ZIP;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Sets the street address.
     *
     * @param street the street address to set
     */
    public void setStreet(String street){
        this.street = street;
    }

    /**
     * Sets the city of residence.
     *
     * @param city the city of residence to set
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * Sets the state of residence.
     *
     * @param state the state of residence to set
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     * Sets the ZIP code.
     *
     * @param ZIP the ZIP code to set
     */
    public void setZIP(int ZIP){
        this.ZIP = ZIP;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the email address.
     *
     * @param emailAddress the email address to set
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**
     * Returns a string representation of the address entry.
     *
     * @return a string representation of the address entry
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" 
        + street + ", " + city + ", " + state + " " + ZIP + "\n" 
        + phoneNumber + "\n" 
        + emailAddress;
    }
}
